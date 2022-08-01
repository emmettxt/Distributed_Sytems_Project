package ds.stockManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.List;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import ds.stockManager.stockManagerGrpc.stockManagerImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StockManagerServer extends stockManagerImplBase {

  private StockDatabase stockDatabase;

  public StockManagerServer() {
    try {
      stockDatabase = StockManagerUtil.parseDatabase();
    } catch (IOException e) {
      stockDatabase = StockDatabase.newBuilder().build();
    }
  }

  public static void main(String[] args) {
    StockManagerServer stockerManagerServer = new StockManagerServer();

    Properties prop = stockerManagerServer.getProperties();
    stockerManagerServer.registerService(prop);

    int port = Integer.valueOf(prop.getProperty("service_port"));

    try {

      Server server = ServerBuilder.forPort(port)
          .addService(stockerManagerServer)
          .build()
          .start();

      System.out.println("Stocker Manager Server Started, listening on " + port);

      server.awaitTermination();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  private Properties getProperties() {

    Properties prop = null;

    try (InputStream input = new FileInputStream("src/main/resources/stockManager.properties")) {

      prop = new Properties();

      // load a properties file
      prop.load(input);

      // get the property value and print it out
      System.out.println("Stock Manager Properties ...");
      System.out.println("\t service_type: " + prop.getProperty("service_type"));
      System.out.println("\t service_name: " + prop.getProperty("service_name"));
      System.out.println("\t service_description: " + prop.getProperty("service_description"));
      System.out.println("\t service_port: " + prop.getProperty("service_port"));

    } catch (IOException ex) {
      ex.printStackTrace();
    }

    return prop;
  }

  private void registerService(Properties prop) {

    try {
      // Create a JmDNS instance
      JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

      String service_type = prop.getProperty("service_type");
      String service_name = prop.getProperty("service_name");
      int service_port = Integer.valueOf(prop.getProperty("service_port"));

      String service_description_properties = prop.getProperty("service_description");

      // Register a service
      ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
          service_description_properties);
      jmdns.registerService(serviceInfo);

      System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

      // Wait a bit
      Thread.sleep(1000);

      // Unregister all services
      // jmdns.unregisterAllServices();

    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public StreamObserver<StockMessage> addStock(StreamObserver<StockMessage> responseObserver) {

    return new StreamObserver<StockMessage>() {

      @Override
      public void onNext(StockMessage stockMessage) {
        // add to database object
        System.out.print("Recieved " + stockMessage.getStockVolume() + " " + stockMessage.getStockType());
        responseObserver.onNext(addToStockDB(stockMessage));

      }

      @Override
      public void onError(Throwable t) {
        // TODO Auto-generated method stub
        System.out.println(t);
      }

      @Override
      public void onCompleted() {
        StockManagerUtil.writeToDB(stockDatabase);
        responseObserver.onCompleted();

      }

    };

  }

  // method that add stock message to Db. Checks if aleardy exists and add to
  // total. or add new item.
  // returns the new StockMessage of that stock type in the DB
  private StockMessage addToStockDB(StockMessage newStockMessage) {
    System.out.println("Adding " + newStockMessage.getStockVolume() + " " + newStockMessage.getStockType() + " to DB");
    StockMessage newTotalStock = null;
    List<StockMessage> stockMessageList = stockDatabase.getStockMessageList();
    ds.stockManager.StockDatabase.Builder newstockDbBuilder = StockDatabase.newBuilder();
    // go through each current stock item
    for (StockMessage stockMessage : stockMessageList) {
      // if is of the same type as new stock item replace with new value
      if (stockMessage.getStockType().equals(newStockMessage.getStockType())) {
        Double newVolume = stockMessage.getStockVolume() + newStockMessage.getStockVolume();
        newTotalStock = StockMessage.newBuilder().setStockType(stockMessage.getStockType()).setStockVolume(newVolume)
            .build();
      }
      // just add to new db
      else {
        newstockDbBuilder.addStockMessage(stockMessage);
      }
    }
    // if stock was not found in DB
    if (newTotalStock == null) {
      newTotalStock = newStockMessage;

    }
    newstockDbBuilder.addStockMessage(newTotalStock);
    stockDatabase = newstockDbBuilder.build();
    return newTotalStock;
  }

  @Override
  public void removeStock(StockMessage stockMessage, StreamObserver<RemoveStockMessage> responseObserver) {
    System.out.println("Request to remove " + stockMessage.getStockVolume() + " of " + stockMessage.getStockType());
    // cehck the database for stock
    for (StockMessage s : stockDatabase.getStockMessageList()) {
      // if exists
      if (s.getStockType().equals(stockMessage.getStockType())) {
        System.out.println("Exists in DB");
        // if the volume is enough
        if (s.getStockVolume() >= stockMessage.getStockVolume()) {
          System.out.println("Enough stock available");
          // add stock with negative amount
          StockMessage newTotalStock = addToStockDB(
              StockMessage.newBuilder()
                  .setStockVolume(-1 * stockMessage.getStockVolume())
                  .setStockType(stockMessage.getStockType())
                  .build());
          responseObserver
              .onNext(RemoveStockMessage.newBuilder().setIsSuccess(true).setStockMessage(newTotalStock).build());
          StockManagerUtil.writeToDB(stockDatabase);
          responseObserver.onCompleted();
          return;
        }
        // else there is not enough stock to remove
        // return failure message with stock volume
        else {
          System.out.println("Not enough stock available");
          
          responseObserver.onNext(RemoveStockMessage.newBuilder().setIsSuccess(false).setStockMessage(s).build());
          responseObserver.onCompleted();
          return;
        }
      }
    }
    System.out.println("No Stock in DB");

    // Stock does not exist at all in DB, return 0
    responseObserver.onNext(
        RemoveStockMessage.newBuilder()
            .setIsSuccess(false)
            .setStockMessage(
                StockMessage
                    .newBuilder()
                    .setStockType(stockMessage.getStockType())
                    .setStockVolume(0))
            .build());
    responseObserver.onCompleted();

  }
  @Override
  public void stockSummary(EmptyStockMessage request, StreamObserver<StockMessage> responseObserver){
    for(StockMessage s: stockDatabase.getStockMessageList()){
      responseObserver.onNext(s);
    }
    responseObserver.onCompleted();
  }
}

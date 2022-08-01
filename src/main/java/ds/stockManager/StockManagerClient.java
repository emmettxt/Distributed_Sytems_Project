package ds.stockManager;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import ds.stockManager.stockManagerGrpc.stockManagerBlockingStub;
import ds.stockManager.stockManagerGrpc.stockManagerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;

public class StockManagerClient {
  private stockManagerBlockingStub blockingStub;
  private stockManagerStub asyncStub;
  private ServiceInfo stockManagerServiceInfo;

  /**
   * @return the blockingStub
   */
  public stockManagerBlockingStub getBlockingStub() {
    return blockingStub;
  }

  /**
   * @return the asyncStub
   */
  public stockManagerStub getAsyncStub() {
    return asyncStub;
  }

  public StockManagerClient() {
    this("_stockManager._tcp.local.");
  }

  public StockManagerClient(String service_type) {
    discoverStockManagerService(service_type);
    String host = stockManagerServiceInfo.getHostAddresses()[0];
    int port = stockManagerServiceInfo.getPort();

    ManagedChannel channel = ManagedChannelBuilder
        .forAddress(host, port)
        .usePlaintext()
        .build();

    blockingStub = stockManagerGrpc.newBlockingStub(channel);

    asyncStub = stockManagerGrpc.newStub(channel);

  }

  private void discoverStockManagerService(String service_type) {

    try {
      // Create a JmDNS instance
      JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

      jmdns.addServiceListener(service_type, new ServiceListener() {

        @Override
        public void serviceResolved(ServiceEvent event) {
          System.out.println("Stock Manager Service resolved: " + event.getInfo());

          stockManagerServiceInfo = event.getInfo();

          int port = stockManagerServiceInfo.getPort();

          System.out.println("resolving " + service_type + " with properties ...");
          System.out.println("\t port: " + port);
          System.out.println("\t type:" + event.getType());
          System.out.println("\t name: " + event.getName());
          System.out.println("\t description/properties: " + stockManagerServiceInfo.getNiceTextString());
          System.out.println("\t host: " + stockManagerServiceInfo.getHostAddresses()[0]);

        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
          System.out.println("Stock Manager Service removed: " + event.getInfo());

        }

        @Override
        public void serviceAdded(ServiceEvent event) {
          System.out.println("Stock Manager Service added: " + event.getInfo());

        }
      });

      // Wait a bit
      Thread.sleep(1000);

      jmdns.close();

    } catch (UnknownHostException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    StockManagerClient stockManagerClient = new StockManagerClient();
    //
    final CountDownLatch finishLatch = new CountDownLatch(1);

    StreamObserver<StockMessage> addStockStreamObserver = stockManagerClient.getAsyncStub()
        .addStock(new StreamObserver<StockMessage>() {

          @Override
          public void onNext(StockMessage value) {
            System.out.println("Total amount of " + value.getStockType() + " is now: " + value.getStockVolume());
          }

          @Override
          public void onError(Throwable t) {
            System.out.println(t);
          }

          @Override
          public void onCompleted() {
            System.out.println("Add stock stream completed.");
            finishLatch.countDown();
          }

        });
    String[] stockTypes = { "Wood", "Diesel", "Grain", "Feed" };
    for (int i = 0; i < 4; i++) {

      StockMessage stockMessage = StockMessage.newBuilder().setStockType(stockTypes[i]).setStockVolume(10 + 10 * i)
          .build();
      System.out
          .println("Adding " + stockMessage.getStockVolume() + " " + stockMessage.getStockType() + " to DB");

      addStockStreamObserver.onNext(stockMessage);
    }
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    addStockStreamObserver.onCompleted();



    ///Remove Stock

    StockMessage removeStock1 = StockMessage.newBuilder().setStockType("Diesel").setStockVolume(10).build();
    StockMessage removeStock2 = StockMessage.newBuilder().setStockType("Diesel").setStockVolume(1000).build();
    StockMessage removeStock3 = StockMessage.newBuilder().setStockType("DNE").setStockVolume(1).build();

    StockMessage[] removMessages = {removeStock1,removeStock2,removeStock3};

    for(StockMessage r: removMessages){
      System.out.println("removing " + r.getStockVolume() + " of " + r.getStockType());
      
      RemoveStockMessage resp = stockManagerClient.getBlockingStub().removeStock(r);
      if(resp.getIsSuccess()){
        System.out.println("removed success current volume of " + resp.getStockMessage().getStockType() + " is " +  resp.getStockMessage().getStockVolume());

      }else{
        System.out.println("removed unsuccessful current volume of " + resp.getStockMessage().getStockType() + " is " +  resp.getStockMessage().getStockVolume());

      }

    }



  }
}

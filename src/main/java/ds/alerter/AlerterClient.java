package ds.alerter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.sound.midi.SysexMessage;

import ds.alerter.AlertMessage.PriorityLevel;
import ds.alerter.AlerterGrpc.AlerterBlockingStub;
import ds.alerter.AlerterGrpc.AlerterStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.scene.control.Alert;

public class AlerterClient {
  private AlerterBlockingStub blockingStub;
  private AlerterStub asyncStub;

  /**
   * @return the blockingStub
   */
  public AlerterBlockingStub getBlockingStub() {
    return blockingStub;
  }

  /**
   * @return the asyncStub
   */
  public AlerterStub getAsyncStub() {
    return asyncStub;
  }

  private ServiceInfo alerterServiceInfo;

  public AlerterClient() {
    this("_alerter._tcp.local.");
  }

  public AlerterClient(String service_type) {
    discoverAlerterService(service_type);

    String host = alerterServiceInfo.getHostAddresses()[0];
    int port = alerterServiceInfo.getPort();

    ManagedChannel channel = ManagedChannelBuilder
        .forAddress(host, port)
        .usePlaintext()
        .build();

    blockingStub = AlerterGrpc.newBlockingStub(channel);

    asyncStub = AlerterGrpc.newStub(channel);
  }

  private void discoverAlerterService(String service_type) {

    try {
      // Create a JmDNS instance
      JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

      jmdns.addServiceListener(service_type, new ServiceListener() {

        @Override
        public void serviceResolved(ServiceEvent event) {
          System.out.println("Alerter Service resolved: " + event.getInfo());

          alerterServiceInfo = event.getInfo();

          int port = alerterServiceInfo.getPort();

          System.out.println("resolving " + service_type + " with properties ...");
          System.out.println("\t port: " + port);
          System.out.println("\t type:" + event.getType());
          System.out.println("\t name: " + event.getName());
          System.out.println("\t description/properties: " + alerterServiceInfo.getNiceTextString());
          System.out.println("\t host: " + alerterServiceInfo.getHostAddresses()[0]);

        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
          System.out.println("Alerter Service removed: " + event.getInfo());

        }

        @Override
        public void serviceAdded(ServiceEvent event) {
          System.out.println("Alerter Service added: " + event.getInfo());

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
    AlerterClient alerterClient = new AlerterClient();
    System.out.println("Registering new Alert");
    AlertMessage alertMessage1 = AlertMessage.newBuilder().setDescription("Alert Description 1")
        .setPriorityLevel(PriorityLevel.HIGH).build();

    AlertDetails alertDetails1 = alerterClient.blockingStub.newAlert(alertMessage1);
    System.out.println("New alert registered: ");
    System.out.println("Id: " + alertDetails1.getAlertId());
    System.out.println("Priority: " + alertDetails1.getAlertMessage().getPriorityLevel());
    System.out.println("Description: " + alertDetails1.getAlertMessage().getDescription() + "\n");

    System.out.println("Registering new Alert");

    AlertMessage alertMessage2 = AlertMessage.newBuilder().setDescription("Alert Description 2")
        .setPriorityLevel(PriorityLevel.LOW).build();

    AlertDetails alertDetails2 = alerterClient.blockingStub.newAlert(alertMessage2);
    System.out.println("New alert registered: ");
    System.out.println("Id: " + alertDetails2.getAlertId());
    System.out.println("Priority: " + alertDetails2.getAlertMessage().getPriorityLevel());
    System.out.println("Description: " + alertDetails2.getAlertMessage().getDescription() + "\n");

    System.out.println("Clearing Alert with id: " + alertDetails2.getAlertId());
    AlertIdMessage alertIdMessage = AlertIdMessage.newBuilder().setAlertId(alertDetails2.getAlertId()).build();
    AlertDetails clearedAlert = alerterClient.blockingStub.clearAlert(alertIdMessage);

    System.out.println("Cleared the following Alert");
    System.out.println("Id: " + clearedAlert.getAlertId());
    System.out.println("Priority: " + clearedAlert.getAlertMessage().getPriorityLevel());
    System.out.println("Description: " + clearedAlert.getAlertMessage().getDescription() + "\n");
  }
}

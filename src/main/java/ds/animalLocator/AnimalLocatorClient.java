package ds.animalLocator;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;

import ds.animalLocator.animalLocatorGrpc.animalLocatorBlockingStub;
import ds.animalLocator.animalLocatorGrpc.animalLocatorStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;

public class AnimalLocatorClient {
    private animalLocatorBlockingStub blockingStub;
    private animalLocatorStub asyncStub;

    /**
     * @return the blockingStub
     */
    public animalLocatorBlockingStub getBlockingStub() {
        return blockingStub;
    }
    /**
     * @return the asyncStub
     */
    public animalLocatorStub getAsyncStub() {
        return asyncStub;
    }

    private ServiceInfo animalLocatorServiceInfo;

    public AnimalLocatorClient(){
        this("_animalLocator._tcp.local.");
    }
    /**
     * @param service_type set equal to "_animalLocator._tcp.local."
     */
    public AnimalLocatorClient(String service_type) {
        discoverAnimalLocatorService(service_type);

        String host = animalLocatorServiceInfo.getHostAddresses()[0];
        int port = animalLocatorServiceInfo.getPort();

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        blockingStub = animalLocatorGrpc.newBlockingStub(channel);

        asyncStub = animalLocatorGrpc.newStub(channel);
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        AnimalLocatorClient animalLocatorClient = new AnimalLocatorClient();
        animalLocatorClient.locationUpdate();
        animalLocatorClient.getCurrentHeardLocation();
    }

    public void locationUpdate() {
        StreamObserver<LocationResponse> responseObserver = new StreamObserver<LocationResponse>() {

            @Override
            public void onNext(LocationResponse msg) {
                System.out.println("Received " + msg.getCountRecieved() + " Locations");
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("stream is completed ... ");
            }

        };
        StreamObserver<LocationMessage> requestObserver = asyncStub.locationUpdater(responseObserver);
        try {
            Point point1 = Point.newBuilder().setLatitude(55).setLongitude(25).build();
            System.out.println("Sending location, Lat: " + point1.getLatitude() + " Long: " + point1.getLongitude());
            long millis = System.currentTimeMillis();
            Timestamp timestamp = Timestamp.newBuilder().setSeconds(millis / 1000)
                    .setNanos((int) ((millis % 1000) * 1000000)).build();
            System.out.println("Time: " + timestamp);
            requestObserver.onNext(
                    LocationMessage
                            .newBuilder()
                            .setAnimalId("AnimalID_1")
                            .setPoint(point1)
                            .setTime(timestamp)
                            .build());

            Thread.sleep(500);

            Point point2 = Point.newBuilder().setLatitude(56).setLongitude(26).build();
            System.out.println("Sending location, Lat: " + point2.getLatitude() + " Long: " + point2.getLongitude());
            requestObserver.onNext(
                    LocationMessage
                            .newBuilder()
                            .setAnimalId("AnimalID_2")
                            .setPoint(point2)
                            .setTime(timestamp)
                            .build());
            Thread.sleep(500);

            requestObserver.onCompleted();
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCurrentHeardLocation() throws InvalidProtocolBufferException {
        EmptyMessage emptyMessage = EmptyMessage.newBuilder().build();
        Iterator<LocationMessage> locationmessages;
        locationmessages = blockingStub.currentHeardLocation(emptyMessage);
        while (locationmessages.hasNext()) {
            LocationMessage l = locationmessages.next();
            String time = JsonFormat.printer().print(l.getTime());
            System.out.println("Latest Location for: " + l.getAnimalId() + " - Long: " + l.getPoint().getLongitude()
                    + " Lat: " + l.getPoint().getLatitude() + " @ " + time);
        }
    }

    /**
     * Returns last N locations of speicic aniamal
     * 
     * @param N        number of locations to return
     * @param animalId the animal id of the locations
     */
    public void getNLocations(int N, String animalId) {
        HeardMemeberNMessage heardMemeberNMessage = HeardMemeberNMessage.newBuilder().setAnimalId(animalId).setN(N)
                .build();
        Iterator<LocationMessage> locationmessages;
        locationmessages = blockingStub.lastNLocations(heardMemeberNMessage);

        int count = 0;
        System.out.println("Last " + N + " Locations for animalId: " + animalId);
        while (locationmessages.hasNext()) {
            LocationMessage l = locationmessages.next();
            count += 1;
            String time;
            try {
                time = JsonFormat.printer().print(l.getTime());
            } catch (InvalidProtocolBufferException e) {
                time = l.getTime().toString();
            }
            System.out.println("Long: " + l.getPoint().getLongitude()
                    + " Lat: " + l.getPoint().getLatitude() + " @ " + time);
        }
        System.out.println(count + " Locations available");

    }

    private void discoverAnimalLocatorService(String service_type) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Animal Locator Service resolved: " + event.getInfo());

                    animalLocatorServiceInfo = event.getInfo();

                    int port = animalLocatorServiceInfo.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:" + event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + animalLocatorServiceInfo.getNiceTextString());
                    System.out.println("\t host: " + animalLocatorServiceInfo.getHostAddresses()[0]);

                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Animal Locator Service removed: " + event.getInfo());

                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Animal Locator Service added: " + event.getInfo());

                }
            });

            // Wait a bit
            Thread.sleep(5000);

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

}

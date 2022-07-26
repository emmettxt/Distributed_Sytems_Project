package ds.animalLocator;

import java.util.Iterator;

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
    private static animalLocatorBlockingStub blockingStub;
    private static animalLocatorStub asynStub;

    public static void main(String[] args) {

        System.out.println("Main...");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext().build();

        blockingStub = animalLocatorGrpc.newBlockingStub(channel);

        asynStub = animalLocatorGrpc.newStub(channel);

        // locationUpdate();
        // try {
        //     getCurrentHeardLocation();
        // } catch (InvalidProtocolBufferException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        try {
            getNLocations(50, "AnimalID_1");
        } catch (InvalidProtocolBufferException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("End Main");
    }

    public static void locationUpdate() {
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
        StreamObserver<LocationMessage> requestObserver = asynStub.locationUpdater(responseObserver);
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

    public static void getCurrentHeardLocation() throws InvalidProtocolBufferException {
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

    public static void getNLocations(int N, String animalId) throws InvalidProtocolBufferException {
        HeardMemeberNMessage heardMemeberNMessage = HeardMemeberNMessage.newBuilder().setAnimalId(animalId).setN(N)
                .build();
        Iterator<LocationMessage> locationmessages;
        locationmessages = blockingStub.lastNLocations(heardMemeberNMessage);

        int count = 0;
        System.out.println("Last " + N + " Locations for animalId: " + animalId);
        while(locationmessages.hasNext()){
            LocationMessage l = locationmessages.next();
            count += 1;
            String time = JsonFormat.printer().print(l.getTime());
            System.out.println("Long: " + l.getPoint().getLongitude()
                    + " Lat: " + l.getPoint().getLatitude() + " @ " + time);
        }
        System.out.println(count + " Locations available");

    }
}

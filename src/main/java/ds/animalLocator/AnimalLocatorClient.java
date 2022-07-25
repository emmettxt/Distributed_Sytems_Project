package ds.animalLocator;


import com.google.protobuf.Timestamp;

import ds.animalLocator.animalLocatorGrpc.animalLocatorBlockingStub;
import ds.animalLocator.animalLocatorGrpc.animalLocatorStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

        locationUpdate();
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
                            .setPoint(point1)
                            .setTime(timestamp)
                            .build());
            Thread.sleep(500);

            requestObserver.onCompleted();
			Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package ds.animalLocator;

import ds.animalLocator.animalLocatorGrpc.animalLocatorImplBase;

import java.io.IOException;

import com.google.protobuf.InvalidProtocolBufferException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;

public class AnimalLocatorServer extends animalLocatorImplBase {
    LocationDatabase locationDatabase;

    AnimalLocatorServer() throws IOException {
        getLocationData();
    }
    /* reads location data from file */

    private void getLocationData() throws IOException {
        locationDatabase = AnimalLocatorUtil.parseLocations(AnimalLocatorUtil.getDefaultLocationsPath());
    }

    public static void main(String[] args) throws IOException {
        AnimalLocatorServer animalLocatorServer = new AnimalLocatorServer();
        int port = 50051;

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(animalLocatorServer)
                    .build()
                    .start();

            System.out.println("Animal Locator Server Started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private LocationMessage lastLocation(String animalId) {
        LocationMessage lastLocation = null;
        for (LocationMessage l : locationDatabase.getLocationMessageList()) {

            if (l.getAnimalId().equals(animalId)) {
                if (lastLocation == null) {
                    lastLocation = l;
                } else if (lastLocation.getTime().getNanos() < l.getTime().getNanos()) {
                    lastLocation = l;
                }
            }
        }
        return lastLocation;
    }

    // add locationMessage to locationMessages and sends to file
    private void newLocationMessage(LocationMessage locationMessage) {
        locationDatabase = LocationDatabase
                .newBuilder()
                .addAllLocationMessage(locationDatabase.getLocationMessageList()) // all previous data
                .addLocationMessage(locationMessage).build(); // newest data
    }

    @Override
    public StreamObserver<LocationMessage> locationUpdater(StreamObserver<LocationResponse> responseObserver) {

        return new StreamObserver<LocationMessage>() {
            int locationCount = 0;
            LocationMessage latest;

            @Override
            public void onNext(LocationMessage locationMessage) {
                System.out.println("OnNext");

                //add location to database object
                newLocationMessage(locationMessage);

                locationCount++;
                latest = locationMessage;

                System.out.println("receiving location, lon: " + locationMessage.getPoint().getLongitude() + " lat: "
                        + locationMessage.getPoint().getLatitude());

            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error");

            }

            @Override
            public void onCompleted() {

                //writes locations to database
                try {
                    AnimalLocatorUtil.writeLocationToDB(locationDatabase);
                } catch (InvalidProtocolBufferException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("receiving locationUpdater method complete");
                LocationResponse response = LocationResponse.newBuilder().setCountRecieved(locationCount)
                        .setLastRecieved(latest).build();

                responseObserver.onNext(response);

                responseObserver.onCompleted();

            }
        };
    }

}

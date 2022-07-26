package ds.animalLocator;

import ds.animalLocator.animalLocatorGrpc.animalLocatorImplBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.Timestamps;

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

                // add location to database object
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

                // writes locations to database
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

    // gets the latest location of for given animal id
    private LocationMessage lastLocation(String animalId){
        List<LocationMessage> sortedLocations = getSortedLocations(animalId);
        return sortedLocations.get(0);
    }
    //get list of locations for a specified animal id, sorted in descending order by timestamp
    private List<LocationMessage> getSortedLocations(String animalId){
        System.out.println("Getting sorted locations for animalid: " + animalId);
        //predicate for filtering location db list for just this animalId
        Predicate<LocationMessage> byAnimalID = locationMessage -> locationMessage.getAnimalId().equals(animalId);
        //doing the filtering
        List<LocationMessage> animalLocations = locationDatabase.getLocationMessageList().stream().filter(byAnimalID)
        .collect(Collectors.toList());
        System.out.println("There are " + animalLocations.size() + " Locations for "  + animalId);
        //sorting the animal list by timestamp
        animalLocations.sort(new Comparator<LocationMessage>() {
            public int compare(LocationMessage l1, LocationMessage l2) {
                return Timestamps.compare(l2.getTime(),l1.getTime());
                
            }
        });

        return animalLocations;
    }

    // gets list of unique animal ids from db
    private ArrayList<String> getUniqueAnimalIDs() {
        System.out.println("Getting Unique animalIds");
        ArrayList<String> animalIDs = new ArrayList<String>();
        for (LocationMessage l : locationDatabase.getLocationMessageList()) {
            if (!animalIDs.contains(l.getAnimalId())) {
                animalIDs.add(l.getAnimalId());
                System.out.println("Got animal Id: " + l.getAnimalId());

            }
        }
        System.out.println("There are " + animalIDs.size() + " unique animals Ids");
        return animalIDs;
    }

    @Override
    public void currentHeardLocation(EmptyMessage request,
            StreamObserver<ds.animalLocator.LocationMessage> responseObserver) {
        // get list of animalids
        ArrayList<String> uniqueAnimalIDs = getUniqueAnimalIDs();
        // get last location of each unique animal id and call onNext
        for (String animalId : uniqueAnimalIDs) {
            responseObserver.onNext(lastLocation(animalId));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void lastNLocations(HeardMemeberNMessage request, StreamObserver<LocationMessage> responseObserver) {
        List<LocationMessage> sortedLocations = getSortedLocations(request.getAnimalId());
        //get the number of locations to send, if less than requested available
        int n = Math.min(sortedLocations.size(), request.getN());
        for(int i = 0; i< n; i++){
            responseObserver.onNext(sortedLocations.get(i));
        }
        responseObserver.onCompleted();
        
    }   
}

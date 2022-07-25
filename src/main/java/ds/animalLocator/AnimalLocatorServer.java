package ds.animalLocator;

import ds.animalLocator.animalLocatorGrpc.animalLocatorImplBase;

import java.io.IOException;
import java.util.Collection;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;

public class AnimalLocatorServer extends animalLocatorImplBase {
    Collection<LocationMessage> locationMessages;
    AnimalLocatorServer() throws IOException{
        locationMessages = AnimalLocatorUtil.parseLocations(AnimalLocatorUtil.getDefaultLocationsFile());
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
    private void addLocation(LocationMessage locationMessage){
        locationMessages.add(locationMessage);
        
    }
    private LocationMessage lastLocation(String animalId){
        LocationMessage lastLocation = null;
        for(LocationMessage l : locationMessages){

            if(l.getAnimalId().equals(animalId)){
                if(lastLocation == null){
                    lastLocation = l;
                }else if(lastLocation.getTime().getNanos() < l.getTime().getNanos() ){
                    lastLocation = l;
                }
            }
        }
        return lastLocation;
    }
    @Override
    public StreamObserver<LocationMessage> locationUpdater(StreamObserver<LocationResponse> responseObserver) {
        
        return new StreamObserver<LocationMessage>() {
            int locationCount = 0;
            LocationMessage latest;

            @Override
            public void onNext(LocationMessage locationMessage) {
                System.out.print("OnNext");
                addLocation(locationMessage);
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
                System.out.println("receiving locationUpdater method complete");
                LocationResponse response = LocationResponse.newBuilder().setCountRecieved(locationCount)
                        .setLastRecieved(latest).build();

                responseObserver.onNext(response);

                responseObserver.onCompleted();

            }
        };
    }

    // public void testSimple(Point point, StreamObserver<Point> responseObserver) {
    //     System.out.println("Recieveing Point, Long: " + point.getLongitude() + " ,Lat: " + point.getLatitude());

    //     Point reply = Point.newBuilder().setLatitude(44).setLongitude(88).build();

    //     responseObserver.onNext(reply);
    //     responseObserver.onCompleted();

    // }

}

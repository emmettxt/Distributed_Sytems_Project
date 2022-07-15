package ds.animalLocator;

import ds.animalLocator.animalLocatorGrpc.animalLocatorImplBase;

import java.io.IOException;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;

public class AnimalLocatorServer extends animalLocatorImplBase{
    public static void main(String[] args) {
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
    public StreamObserver<LocationMessage>  locationUpdater(StreamObserver<LocationResponse> responseObserver){
        
        
        return new StreamObserver<LocationMessage>() {
            int locationCount;
            LocationMessage latest;
            @Override
            public void onNext(LocationMessage locationMessage){
                locationCount++;
                latest = locationMessage;
                System.out.println("receiving location, lon: " + locationMessage.getPoint().getLongitude() + " lot: " + locationMessage.getPoint().getLatitude());

            }
            @Override
            public void onError(Throwable t){

            }
            @Override
            public void onCompleted(){
				System.out.println("receiving locationUpdater method complete");
                LocationResponse response = LocationResponse.newBuilder().setCountRecieved(locationCount).setLastRecieved(latest).build();

                responseObserver.onNext(response);

                responseObserver.onCompleted();



            }
        };
    }
    
}

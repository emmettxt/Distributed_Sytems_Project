package ds.animalLocator;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: animalLocator.proto")
public final class animalLocatorGrpc {

  private animalLocatorGrpc() {}

  public static final String SERVICE_NAME = "animalLocator.animalLocator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.animalLocator.LocationMessage,
      ds.animalLocator.LocationResponse> getLocationUpdaterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LocationUpdater",
      requestType = ds.animalLocator.LocationMessage.class,
      responseType = ds.animalLocator.LocationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.animalLocator.LocationMessage,
      ds.animalLocator.LocationResponse> getLocationUpdaterMethod() {
    io.grpc.MethodDescriptor<ds.animalLocator.LocationMessage, ds.animalLocator.LocationResponse> getLocationUpdaterMethod;
    if ((getLocationUpdaterMethod = animalLocatorGrpc.getLocationUpdaterMethod) == null) {
      synchronized (animalLocatorGrpc.class) {
        if ((getLocationUpdaterMethod = animalLocatorGrpc.getLocationUpdaterMethod) == null) {
          animalLocatorGrpc.getLocationUpdaterMethod = getLocationUpdaterMethod = 
              io.grpc.MethodDescriptor.<ds.animalLocator.LocationMessage, ds.animalLocator.LocationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "animalLocator.animalLocator", "LocationUpdater"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.animalLocator.LocationMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.animalLocator.LocationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new animalLocatorMethodDescriptorSupplier("LocationUpdater"))
                  .build();
          }
        }
     }
     return getLocationUpdaterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.animalLocator.EmptyMessage,
      ds.animalLocator.LocationMessage> getCurrentHeardLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CurrentHeardLocation",
      requestType = ds.animalLocator.EmptyMessage.class,
      responseType = ds.animalLocator.LocationMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.animalLocator.EmptyMessage,
      ds.animalLocator.LocationMessage> getCurrentHeardLocationMethod() {
    io.grpc.MethodDescriptor<ds.animalLocator.EmptyMessage, ds.animalLocator.LocationMessage> getCurrentHeardLocationMethod;
    if ((getCurrentHeardLocationMethod = animalLocatorGrpc.getCurrentHeardLocationMethod) == null) {
      synchronized (animalLocatorGrpc.class) {
        if ((getCurrentHeardLocationMethod = animalLocatorGrpc.getCurrentHeardLocationMethod) == null) {
          animalLocatorGrpc.getCurrentHeardLocationMethod = getCurrentHeardLocationMethod = 
              io.grpc.MethodDescriptor.<ds.animalLocator.EmptyMessage, ds.animalLocator.LocationMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "animalLocator.animalLocator", "CurrentHeardLocation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.animalLocator.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.animalLocator.LocationMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new animalLocatorMethodDescriptorSupplier("CurrentHeardLocation"))
                  .build();
          }
        }
     }
     return getCurrentHeardLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.animalLocator.HeardMemeberNMessage,
      ds.animalLocator.LocationMessage> getLastNLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LastNLocations",
      requestType = ds.animalLocator.HeardMemeberNMessage.class,
      responseType = ds.animalLocator.LocationMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.animalLocator.HeardMemeberNMessage,
      ds.animalLocator.LocationMessage> getLastNLocationsMethod() {
    io.grpc.MethodDescriptor<ds.animalLocator.HeardMemeberNMessage, ds.animalLocator.LocationMessage> getLastNLocationsMethod;
    if ((getLastNLocationsMethod = animalLocatorGrpc.getLastNLocationsMethod) == null) {
      synchronized (animalLocatorGrpc.class) {
        if ((getLastNLocationsMethod = animalLocatorGrpc.getLastNLocationsMethod) == null) {
          animalLocatorGrpc.getLastNLocationsMethod = getLastNLocationsMethod = 
              io.grpc.MethodDescriptor.<ds.animalLocator.HeardMemeberNMessage, ds.animalLocator.LocationMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "animalLocator.animalLocator", "LastNLocations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.animalLocator.HeardMemeberNMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.animalLocator.LocationMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new animalLocatorMethodDescriptorSupplier("LastNLocations"))
                  .build();
          }
        }
     }
     return getLastNLocationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static animalLocatorStub newStub(io.grpc.Channel channel) {
    return new animalLocatorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static animalLocatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new animalLocatorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static animalLocatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new animalLocatorFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class animalLocatorImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *stream of LocationMesssages from client, server should return last recieved message.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage> locationUpdater(
        io.grpc.stub.StreamObserver<ds.animalLocator.LocationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLocationUpdaterMethod(), responseObserver);
    }

    /**
     * <pre>
     *returns stream of latest location for each unique animalid in db
     *need to send empty message 
     * </pre>
     */
    public void currentHeardLocation(ds.animalLocator.EmptyMessage request,
        io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrentHeardLocationMethod(), responseObserver);
    }

    /**
     */
    public void lastNLocations(ds.animalLocator.HeardMemeberNMessage request,
        io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getLastNLocationsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLocationUpdaterMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.animalLocator.LocationMessage,
                ds.animalLocator.LocationResponse>(
                  this, METHODID_LOCATION_UPDATER)))
          .addMethod(
            getCurrentHeardLocationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.animalLocator.EmptyMessage,
                ds.animalLocator.LocationMessage>(
                  this, METHODID_CURRENT_HEARD_LOCATION)))
          .addMethod(
            getLastNLocationsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.animalLocator.HeardMemeberNMessage,
                ds.animalLocator.LocationMessage>(
                  this, METHODID_LAST_NLOCATIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class animalLocatorStub extends io.grpc.stub.AbstractStub<animalLocatorStub> {
    private animalLocatorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private animalLocatorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected animalLocatorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new animalLocatorStub(channel, callOptions);
    }

    /**
     * <pre>
     *stream of LocationMesssages from client, server should return last recieved message.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage> locationUpdater(
        io.grpc.stub.StreamObserver<ds.animalLocator.LocationResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLocationUpdaterMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *returns stream of latest location for each unique animalid in db
     *need to send empty message 
     * </pre>
     */
    public void currentHeardLocation(ds.animalLocator.EmptyMessage request,
        io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCurrentHeardLocationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lastNLocations(ds.animalLocator.HeardMemeberNMessage request,
        io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLastNLocationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class animalLocatorBlockingStub extends io.grpc.stub.AbstractStub<animalLocatorBlockingStub> {
    private animalLocatorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private animalLocatorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected animalLocatorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new animalLocatorBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *returns stream of latest location for each unique animalid in db
     *need to send empty message 
     * </pre>
     */
    public java.util.Iterator<ds.animalLocator.LocationMessage> currentHeardLocation(
        ds.animalLocator.EmptyMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getCurrentHeardLocationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.animalLocator.LocationMessage> lastNLocations(
        ds.animalLocator.HeardMemeberNMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getLastNLocationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class animalLocatorFutureStub extends io.grpc.stub.AbstractStub<animalLocatorFutureStub> {
    private animalLocatorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private animalLocatorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected animalLocatorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new animalLocatorFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CURRENT_HEARD_LOCATION = 0;
  private static final int METHODID_LAST_NLOCATIONS = 1;
  private static final int METHODID_LOCATION_UPDATER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final animalLocatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(animalLocatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CURRENT_HEARD_LOCATION:
          serviceImpl.currentHeardLocation((ds.animalLocator.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage>) responseObserver);
          break;
        case METHODID_LAST_NLOCATIONS:
          serviceImpl.lastNLocations((ds.animalLocator.HeardMemeberNMessage) request,
              (io.grpc.stub.StreamObserver<ds.animalLocator.LocationMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOCATION_UPDATER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.locationUpdater(
              (io.grpc.stub.StreamObserver<ds.animalLocator.LocationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class animalLocatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    animalLocatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.animalLocator.AnimalLocatorImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("animalLocator");
    }
  }

  private static final class animalLocatorFileDescriptorSupplier
      extends animalLocatorBaseDescriptorSupplier {
    animalLocatorFileDescriptorSupplier() {}
  }

  private static final class animalLocatorMethodDescriptorSupplier
      extends animalLocatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    animalLocatorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (animalLocatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new animalLocatorFileDescriptorSupplier())
              .addMethod(getLocationUpdaterMethod())
              .addMethod(getCurrentHeardLocationMethod())
              .addMethod(getLastNLocationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

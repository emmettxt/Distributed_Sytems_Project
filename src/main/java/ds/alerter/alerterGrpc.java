package ds.alerter;

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
    comments = "Source: alerter.proto")
public final class alerterGrpc {

  private alerterGrpc() {}

  public static final String SERVICE_NAME = "alerter.alerter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.alerter.alertMessage,
      ds.alerter.alertDetails> getNewAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newAlert",
      requestType = ds.alerter.alertMessage.class,
      responseType = ds.alerter.alertDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.alerter.alertMessage,
      ds.alerter.alertDetails> getNewAlertMethod() {
    io.grpc.MethodDescriptor<ds.alerter.alertMessage, ds.alerter.alertDetails> getNewAlertMethod;
    if ((getNewAlertMethod = alerterGrpc.getNewAlertMethod) == null) {
      synchronized (alerterGrpc.class) {
        if ((getNewAlertMethod = alerterGrpc.getNewAlertMethod) == null) {
          alerterGrpc.getNewAlertMethod = getNewAlertMethod = 
              io.grpc.MethodDescriptor.<ds.alerter.alertMessage, ds.alerter.alertDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alerter.alerter", "newAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.alertMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.alertDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new alerterMethodDescriptorSupplier("newAlert"))
                  .build();
          }
        }
     }
     return getNewAlertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.alerter.alertIdMessage,
      ds.alerter.alertDetails> getClearAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clearAlert",
      requestType = ds.alerter.alertIdMessage.class,
      responseType = ds.alerter.alertDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.alerter.alertIdMessage,
      ds.alerter.alertDetails> getClearAlertMethod() {
    io.grpc.MethodDescriptor<ds.alerter.alertIdMessage, ds.alerter.alertDetails> getClearAlertMethod;
    if ((getClearAlertMethod = alerterGrpc.getClearAlertMethod) == null) {
      synchronized (alerterGrpc.class) {
        if ((getClearAlertMethod = alerterGrpc.getClearAlertMethod) == null) {
          alerterGrpc.getClearAlertMethod = getClearAlertMethod = 
              io.grpc.MethodDescriptor.<ds.alerter.alertIdMessage, ds.alerter.alertDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alerter.alerter", "clearAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.alertIdMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.alertDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new alerterMethodDescriptorSupplier("clearAlert"))
                  .build();
          }
        }
     }
     return getClearAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static alerterStub newStub(io.grpc.Channel channel) {
    return new alerterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static alerterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new alerterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static alerterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new alerterFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class alerterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public void newAlert(ds.alerter.alertMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.alertDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getNewAlertMethod(), responseObserver);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public void clearAlert(ds.alerter.alertIdMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.alertDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getClearAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.alerter.alertMessage,
                ds.alerter.alertDetails>(
                  this, METHODID_NEW_ALERT)))
          .addMethod(
            getClearAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.alerter.alertIdMessage,
                ds.alerter.alertDetails>(
                  this, METHODID_CLEAR_ALERT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class alerterStub extends io.grpc.stub.AbstractStub<alerterStub> {
    private alerterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alerterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alerterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alerterStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public void newAlert(ds.alerter.alertMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.alertDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNewAlertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public void clearAlert(ds.alerter.alertIdMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.alertDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClearAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class alerterBlockingStub extends io.grpc.stub.AbstractStub<alerterBlockingStub> {
    private alerterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alerterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alerterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alerterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public ds.alerter.alertDetails newAlert(ds.alerter.alertMessage request) {
      return blockingUnaryCall(
          getChannel(), getNewAlertMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public ds.alerter.alertDetails clearAlert(ds.alerter.alertIdMessage request) {
      return blockingUnaryCall(
          getChannel(), getClearAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class alerterFutureStub extends io.grpc.stub.AbstractStub<alerterFutureStub> {
    private alerterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alerterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alerterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alerterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.alerter.alertDetails> newAlert(
        ds.alerter.alertMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getNewAlertMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.alerter.alertDetails> clearAlert(
        ds.alerter.alertIdMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getClearAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_ALERT = 0;
  private static final int METHODID_CLEAR_ALERT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final alerterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(alerterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_ALERT:
          serviceImpl.newAlert((ds.alerter.alertMessage) request,
              (io.grpc.stub.StreamObserver<ds.alerter.alertDetails>) responseObserver);
          break;
        case METHODID_CLEAR_ALERT:
          serviceImpl.clearAlert((ds.alerter.alertIdMessage) request,
              (io.grpc.stub.StreamObserver<ds.alerter.alertDetails>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class alerterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    alerterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.alerter.AlerterImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("alerter");
    }
  }

  private static final class alerterFileDescriptorSupplier
      extends alerterBaseDescriptorSupplier {
    alerterFileDescriptorSupplier() {}
  }

  private static final class alerterMethodDescriptorSupplier
      extends alerterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    alerterMethodDescriptorSupplier(String methodName) {
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
      synchronized (alerterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new alerterFileDescriptorSupplier())
              .addMethod(getNewAlertMethod())
              .addMethod(getClearAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}

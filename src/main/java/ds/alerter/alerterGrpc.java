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
public final class AlerterGrpc {

  private AlerterGrpc() {}

  public static final String SERVICE_NAME = "alerter.Alerter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.alerter.AlertMessage,
      ds.alerter.AlertDetails> getNewAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NewAlert",
      requestType = ds.alerter.AlertMessage.class,
      responseType = ds.alerter.AlertDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.alerter.AlertMessage,
      ds.alerter.AlertDetails> getNewAlertMethod() {
    io.grpc.MethodDescriptor<ds.alerter.AlertMessage, ds.alerter.AlertDetails> getNewAlertMethod;
    if ((getNewAlertMethod = AlerterGrpc.getNewAlertMethod) == null) {
      synchronized (AlerterGrpc.class) {
        if ((getNewAlertMethod = AlerterGrpc.getNewAlertMethod) == null) {
          AlerterGrpc.getNewAlertMethod = getNewAlertMethod = 
              io.grpc.MethodDescriptor.<ds.alerter.AlertMessage, ds.alerter.AlertDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alerter.Alerter", "NewAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.AlertMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.AlertDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new AlerterMethodDescriptorSupplier("NewAlert"))
                  .build();
          }
        }
     }
     return getNewAlertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.alerter.AlertIdMessage,
      ds.alerter.AlertDetails> getClearAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClearAlert",
      requestType = ds.alerter.AlertIdMessage.class,
      responseType = ds.alerter.AlertDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.alerter.AlertIdMessage,
      ds.alerter.AlertDetails> getClearAlertMethod() {
    io.grpc.MethodDescriptor<ds.alerter.AlertIdMessage, ds.alerter.AlertDetails> getClearAlertMethod;
    if ((getClearAlertMethod = AlerterGrpc.getClearAlertMethod) == null) {
      synchronized (AlerterGrpc.class) {
        if ((getClearAlertMethod = AlerterGrpc.getClearAlertMethod) == null) {
          AlerterGrpc.getClearAlertMethod = getClearAlertMethod = 
              io.grpc.MethodDescriptor.<ds.alerter.AlertIdMessage, ds.alerter.AlertDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alerter.Alerter", "ClearAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.AlertIdMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alerter.AlertDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new AlerterMethodDescriptorSupplier("ClearAlert"))
                  .build();
          }
        }
     }
     return getClearAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlerterStub newStub(io.grpc.Channel channel) {
    return new AlerterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlerterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AlerterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlerterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AlerterFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class AlerterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public void newAlert(ds.alerter.AlertMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.AlertDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getNewAlertMethod(), responseObserver);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public void clearAlert(ds.alerter.AlertIdMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.AlertDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getClearAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.alerter.AlertMessage,
                ds.alerter.AlertDetails>(
                  this, METHODID_NEW_ALERT)))
          .addMethod(
            getClearAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.alerter.AlertIdMessage,
                ds.alerter.AlertDetails>(
                  this, METHODID_CLEAR_ALERT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class AlerterStub extends io.grpc.stub.AbstractStub<AlerterStub> {
    private AlerterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlerterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlerterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlerterStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public void newAlert(ds.alerter.AlertMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.AlertDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNewAlertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public void clearAlert(ds.alerter.AlertIdMessage request,
        io.grpc.stub.StreamObserver<ds.alerter.AlertDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClearAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class AlerterBlockingStub extends io.grpc.stub.AbstractStub<AlerterBlockingStub> {
    private AlerterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlerterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlerterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlerterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public ds.alerter.AlertDetails newAlert(ds.alerter.AlertMessage request) {
      return blockingUnaryCall(
          getChannel(), getNewAlertMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public ds.alerter.AlertDetails clearAlert(ds.alerter.AlertIdMessage request) {
      return blockingUnaryCall(
          getChannel(), getClearAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class AlerterFutureStub extends io.grpc.stub.AbstractStub<AlerterFutureStub> {
    private AlerterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlerterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlerterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlerterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add new alert to server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.alerter.AlertDetails> newAlert(
        ds.alerter.AlertMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getNewAlertMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *clears and alert from server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.alerter.AlertDetails> clearAlert(
        ds.alerter.AlertIdMessage request) {
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
    private final AlerterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlerterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_ALERT:
          serviceImpl.newAlert((ds.alerter.AlertMessage) request,
              (io.grpc.stub.StreamObserver<ds.alerter.AlertDetails>) responseObserver);
          break;
        case METHODID_CLEAR_ALERT:
          serviceImpl.clearAlert((ds.alerter.AlertIdMessage) request,
              (io.grpc.stub.StreamObserver<ds.alerter.AlertDetails>) responseObserver);
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

  private static abstract class AlerterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlerterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.alerter.AlerterImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Alerter");
    }
  }

  private static final class AlerterFileDescriptorSupplier
      extends AlerterBaseDescriptorSupplier {
    AlerterFileDescriptorSupplier() {}
  }

  private static final class AlerterMethodDescriptorSupplier
      extends AlerterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlerterMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlerterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlerterFileDescriptorSupplier())
              .addMethod(getNewAlertMethod())
              .addMethod(getClearAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}

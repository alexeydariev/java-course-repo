package student.examples;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.4)",
    comments = "Source: hub.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CalculationServiceGrpc {

  private CalculationServiceGrpc() {}

  public static final String SERVICE_NAME = "CalculationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<student.examples.Hub.Command,
      student.examples.Hub.Command> getCalculateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Calculate",
      requestType = student.examples.Hub.Command.class,
      responseType = student.examples.Hub.Command.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<student.examples.Hub.Command,
      student.examples.Hub.Command> getCalculateMethod() {
    io.grpc.MethodDescriptor<student.examples.Hub.Command, student.examples.Hub.Command> getCalculateMethod;
    if ((getCalculateMethod = CalculationServiceGrpc.getCalculateMethod) == null) {
      synchronized (CalculationServiceGrpc.class) {
        if ((getCalculateMethod = CalculationServiceGrpc.getCalculateMethod) == null) {
          CalculationServiceGrpc.getCalculateMethod = getCalculateMethod =
              io.grpc.MethodDescriptor.<student.examples.Hub.Command, student.examples.Hub.Command>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Calculate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  student.examples.Hub.Command.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  student.examples.Hub.Command.getDefaultInstance()))
              .setSchemaDescriptor(new CalculationServiceMethodDescriptorSupplier("Calculate"))
              .build();
        }
      }
    }
    return getCalculateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<student.examples.Hub.Response,
      student.examples.Hub.Response> getRespondMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Respond",
      requestType = student.examples.Hub.Response.class,
      responseType = student.examples.Hub.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<student.examples.Hub.Response,
      student.examples.Hub.Response> getRespondMethod() {
    io.grpc.MethodDescriptor<student.examples.Hub.Response, student.examples.Hub.Response> getRespondMethod;
    if ((getRespondMethod = CalculationServiceGrpc.getRespondMethod) == null) {
      synchronized (CalculationServiceGrpc.class) {
        if ((getRespondMethod = CalculationServiceGrpc.getRespondMethod) == null) {
          CalculationServiceGrpc.getRespondMethod = getRespondMethod =
              io.grpc.MethodDescriptor.<student.examples.Hub.Response, student.examples.Hub.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Respond"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  student.examples.Hub.Response.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  student.examples.Hub.Response.getDefaultInstance()))
              .setSchemaDescriptor(new CalculationServiceMethodDescriptorSupplier("Respond"))
              .build();
        }
      }
    }
    return getRespondMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculationServiceStub>() {
        @java.lang.Override
        public CalculationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculationServiceStub(channel, callOptions);
        }
      };
    return CalculationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculationServiceBlockingStub>() {
        @java.lang.Override
        public CalculationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculationServiceBlockingStub(channel, callOptions);
        }
      };
    return CalculationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculationServiceFutureStub>() {
        @java.lang.Override
        public CalculationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculationServiceFutureStub(channel, callOptions);
        }
      };
    return CalculationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CalculationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculate(student.examples.Hub.Command request,
        io.grpc.stub.StreamObserver<student.examples.Hub.Command> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCalculateMethod(), responseObserver);
    }

    /**
     */
    public void respond(student.examples.Hub.Response request,
        io.grpc.stub.StreamObserver<student.examples.Hub.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRespondMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                student.examples.Hub.Command,
                student.examples.Hub.Command>(
                  this, METHODID_CALCULATE)))
          .addMethod(
            getRespondMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                student.examples.Hub.Response,
                student.examples.Hub.Response>(
                  this, METHODID_RESPOND)))
          .build();
    }
  }

  /**
   */
  public static final class CalculationServiceStub extends io.grpc.stub.AbstractAsyncStub<CalculationServiceStub> {
    private CalculationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculationServiceStub(channel, callOptions);
    }

    /**
     */
    public void calculate(student.examples.Hub.Command request,
        io.grpc.stub.StreamObserver<student.examples.Hub.Command> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void respond(student.examples.Hub.Response request,
        io.grpc.stub.StreamObserver<student.examples.Hub.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRespondMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalculationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CalculationServiceBlockingStub> {
    private CalculationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public student.examples.Hub.Command calculate(student.examples.Hub.Command request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateMethod(), getCallOptions(), request);
    }

    /**
     */
    public student.examples.Hub.Response respond(student.examples.Hub.Response request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRespondMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CalculationServiceFutureStub> {
    private CalculationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<student.examples.Hub.Command> calculate(
        student.examples.Hub.Command request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<student.examples.Hub.Response> respond(
        student.examples.Hub.Response request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRespondMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE = 0;
  private static final int METHODID_RESPOND = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE:
          serviceImpl.calculate((student.examples.Hub.Command) request,
              (io.grpc.stub.StreamObserver<student.examples.Hub.Command>) responseObserver);
          break;
        case METHODID_RESPOND:
          serviceImpl.respond((student.examples.Hub.Response) request,
              (io.grpc.stub.StreamObserver<student.examples.Hub.Response>) responseObserver);
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

  private static abstract class CalculationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return student.examples.Hub.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculationService");
    }
  }

  private static final class CalculationServiceFileDescriptorSupplier
      extends CalculationServiceBaseDescriptorSupplier {
    CalculationServiceFileDescriptorSupplier() {}
  }

  private static final class CalculationServiceMethodDescriptorSupplier
      extends CalculationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculationServiceFileDescriptorSupplier())
              .addMethod(getCalculateMethod())
              .addMethod(getRespondMethod())
              .build();
        }
      }
    }
    return result;
  }
}

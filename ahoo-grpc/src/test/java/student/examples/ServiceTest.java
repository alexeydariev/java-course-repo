package student.examples;

import io.grpc.*;
import io.grpc.inprocess.InProcessServerBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.grpc.Status.UNKNOWN;

public class ServiceTest {
    ManagedChannel channel;
    CalculationServiceGrpc.CalculationServiceBlockingStub stub;

    @BeforeTest
    public void setUp() throws Exception {
        // Generate a unique in-process server name.
        channel = ManagedChannelBuilder.forAddress("localhost", 6666)
                .usePlaintext()
                .build();
        stub = CalculationServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void sendRequest() {
        Hub.Command comm = stub.calculate(Hub.Command.newBuilder().setType(1).setBody("1,2,3,4,5").build());
        Assert.assertEquals(Integer.parseInt(comm.getBody()), 6);
    }

    @Test (expectedExceptions = {StatusRuntimeException.class})
    public void sendCorruptedRequest() {
        Hub.Command comm = stub.calculate(Hub.Command.newBuilder().setType(1).setBody("AAAA").build());
        if (comm.getType() == -1) throw new StatusRuntimeException(UNKNOWN);
    }

    @AfterTest
    public void tearDown(){
        channel.shutdown();

    }
}

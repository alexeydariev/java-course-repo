package student.examples;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server;

        server = ServerBuilder
                .forPort(6666)
                .addService(new Service())
                .build();

        server.start();
        System.out.println("SERVER RUNNING");
        server.awaitTermination();
        System.out.println("SERVER STOPPED");
    }
}

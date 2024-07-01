package student.examples;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serial;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;


public class ClientApp {
    public static void main(String[] args) throws Exception {
        final Integer PORT = 20000;

        Socket clientSocket = new Socket("localhost", PORT);
        System.out.println("Client connected to server ");

        // Scanner inputScanner = new Scanner(System.in);
        //String msg = inputScanner.nextLine();
        OutputStream os = clientSocket.getOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(os); //decorator
        Message message = new Message(UUID.randomUUID(), "SASI");
        oos.writeObject(message);
        new Scanner(System.in).next();

        oos.close();
        clientSocket.close();
    }
}

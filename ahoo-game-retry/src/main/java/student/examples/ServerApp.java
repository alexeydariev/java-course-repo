package student.examples;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class ServerApp {
    public static void main(String[] args) throws Exception {

        final Integer PORT = 20000;
        ServerSocket serverSocket = new ServerSocket(PORT);

        //listening
        System.out.println("Server running");
        Socket clientSocket = serverSocket.accept();
        System.out.println("A client is connected");

        InputStream is = clientSocket.getInputStream();

        ObjectInputStream ois = new ObjectInputStream(is);

        Message message = (Message) ois.readObject();
        //byte[] data = is.readAllBytes();
        //String msg = new String(data);
        new Scanner(System.in).next();

        ois.close();
        clientSocket.close();

        System.out.println("Client sent: " + message);

    }
}

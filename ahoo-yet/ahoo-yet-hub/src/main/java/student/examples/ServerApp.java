package student.examples;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import student.examples.comm.Command;
import student.examples.comm.ServerCommand;
import student.examples.config.Configuration;
import student.examples.devices.DeviceInterface;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static student.examples.comm.CommandType.*;

public class ServerApp
{
    final static Logger logger = LoggerFactory.getLogger(ServerApp.class);
    private Set<Map<String, Object>> connections;
    private ServerSocket serverSocket;

    public ServerApp (int port) throws IOException {
        create(port);
    }

    private void create(int port) throws IOException {
        connections = new HashSet<>();
        serverSocket = new ServerSocket(port, 0, InetAddress.getLocalHost());
    }

    private void listen() throws IOException, ClassNotFoundException { //await for conn
        while (true) {
            Socket clientSocket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            Command command = (Command) ois.readObject();
            if (command.getType() == IDENTITY) {
                DeviceInterface device = (DeviceInterface) command.getBody();
                logger.info(String.format("SERVER: Client connected from: %s", clientSocket.getInetAddress()));
                Map<String, Object> client = new HashMap<>();
                client.put("socket", clientSocket);
                client.put("device", device);
                connections.add(client);
                logger.info("added");
                respondAcknowledge(clientSocket);

            }
        }
    }

    public void respondAcknowledge(Socket clientSocket) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        oos.writeObject(new ServerCommand(ACKNOWLEDGE, null));
        logger.info("ACKNOWLEDGE sent");
    }

    public static void main ( String[] args ) throws Exception
    {
        logger.info("SERVER INITIALIZING");
        ServerApp app = new ServerApp(Configuration.PORT);
        logger.info("SERVER STARTING");
        app.listen();
        logger.info("SERVER SHITTING DOWN");


        /*
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        ServerCommand serverCommand = new ServerCommand(TURN_ON);
        oos.writeObject(serverCommand);
        //System.out.println(ois.readObject().getClass());
        ClientCommand clientCommand = (ClientCommand) ois.readObject();
        logger.info("RECEIVED COMMAND: " + clientCommand.getType());

        if (clientCommand.getType().equals(ACKNOWLEDGE)) {
            logger.info("SENDING TURN OFF");
            oos.writeObject(new ServerCommand(TURN_OFF));
        }

        ClientCommand newClientCommand = (ClientCommand) ois.readObject();
        logger.info("RECEIVED COMMAND: " + newClientCommand.getType());

        //serverSocket.accept();
        logger.info("STOPPED");*/

    }
}

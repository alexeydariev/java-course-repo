package student.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import student.examples.comm.ClientCommand;
import student.examples.comm.CommandType;
import student.examples.comm.ServerCommand;
import student.examples.config.Configuration;
import student.examples.devices.VacuumCleaner;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class VacuumCleanerApp
{
    public static final Logger logger = LoggerFactory.getLogger(VacuumCleanerApp.class);
    public static void main( String[] args ) throws Exception
    {
        Socket socket = new Socket(InetAddress.getLocalHost(), Configuration.PORT);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        VacuumCleaner vacuumCleaner = new VacuumCleaner(1, "sosyot");
        ClientCommand clientCommand = new ClientCommand(CommandType.IDENTITY, vacuumCleaner);
        logger.info("SEND IDENTITY: " + clientCommand);
        oos.writeObject(clientCommand);
        oos.flush();
        receiveAcknowledge(socket);
    }

    public static void receiveAcknowledge(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        logger.info("RECEIVED ACK: " + ois.readObject());
    }
}

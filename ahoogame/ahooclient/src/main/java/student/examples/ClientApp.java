package student.examples;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp
{
    public static void main( String[] args ) throws Exception {

        Socket socket = new Socket("localhost", 10001);
        System.out.println("Client started");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        System.out.println("GAME STARTED:\n choose player name");
        String nickname = scanner.next();
        Player player = new Player(nickname, 0);

        Frame frame = new Frame("connect", player);
        oos.writeObject(frame);
        oos.close();
        socket.close();
        System.out.println("Clent sent frame");

    }
}

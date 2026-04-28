package en.ase.csie;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("Localhost");
            int port = 8888;
            String msg = "Hello from the other side!";

            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, port);
            socket.send(packet);

            System.out.println("Message sent to server.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

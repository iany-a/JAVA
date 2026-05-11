package en.csie.acs;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient extends Thread {

    static int port = 8888;
    DatagramSocket socket;
    static InetAddress address;
    static final int MAX_MSG_SIZE = 500;

    UDPClient(int port){
        this.port = port;

        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        super.run();
        while(true){
            byte[] buffer = new byte[MAX_MSG_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                System.out.println("Message received: " + new String(packet.getData(),0,packet.getLength()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UDPClient udpClient = new UDPClient(8888);
        udpClient.start();
        try{
            while(true){
                String msg = scanner.nextLine();

                DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, port);
                udpClient.socket.send(packet);
                System.out.println("[DEBUG]: Message Sent!");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

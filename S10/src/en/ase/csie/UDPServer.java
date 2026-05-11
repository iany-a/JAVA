package en.csie.acs;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPServer extends Thread{
    int port = 8888;
    static final int MAX_MSG_SIZE = 500;
    byte[] buffer= null;
    DatagramSocket socket;

    UDPServer(int port){
        this.port = port;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        super.run();
        while(true){
            buffer = new byte[MAX_MSG_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet); // BLOCKING
                System.out.println("Message received: " + new String(packet.getData(),0,packet.getLength()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        UDPServer udpServer = new UDPServer(8888);

        try {
            byte[] buffer = new byte[MAX_MSG_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            udpServer.socket.receive(packet); // BLOCKING
            System.out.println("Message received: " + new String(packet.getData(),0,packet.getLength()));
            InetAddress address = packet.getAddress();
            int port =  packet.getPort();
            udpServer.start();

            while(true){
                String msg = scanner.nextLine(); // BLOCKING
                udpServer.socket.send(new DatagramPacket(msg.getBytes(), msg.length(), address ,port));
                System.out.println("[DEBUG]: Message sent!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

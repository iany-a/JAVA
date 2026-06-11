package carRental;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class TCPClient {
    private int port;
    private String hostname;

    public TCPClient(int port, String hostname) {
        this.port = port;
        this.hostname = hostname;
    }

    public void sendDataToServer(String pathTxt){

        System.out.println("Input txt files translated to list.");
        try(Socket clientSocket = new Socket(this.hostname, this.port)){
            List<Vehicle> carList = Utils.readInListTxt(pathTxt);
            Utils.serializeToStream(clientSocket.getOutputStream(), carList);
            System.out.println("Sent car list.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TCPClient client = new TCPClient(5000, "localhost");
        System.out.println("Starting TCP Client...");
        client.sendDataToServer(Utils.directory + "input.txt");
        System.out.println("DONE");
    }

}

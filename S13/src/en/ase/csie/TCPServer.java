package en.ase.csie;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            Socket socket = serverSocket.accept(); //equivalent of receive in UDP, blocking operation
            InputStream inputStream = socket.getInputStream(); //for reading
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String msg = dataInputStream.readUTF();
            System.out.println("Message received: " + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

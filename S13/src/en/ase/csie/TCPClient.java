package en.ase.csie;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try(Socket clientSocket = new Socket("localhost", 8888)) {
            OutputStream outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String msg = "Hello";
            dataOutputStream.writeUTF(msg);
            System.out.println("Message sent: " + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

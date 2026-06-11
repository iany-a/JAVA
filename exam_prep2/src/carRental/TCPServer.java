package carRental;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000;
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Multithreaded server started on port " + port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted client...");
                threadPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

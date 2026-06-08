package subjects.airplane.server;

import subjects.airplane.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000;
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        System.out.println("Multi threading server started.");

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from: " + socket.getRemoteSocketAddress());
                threadPool.execute(new ClientHandler(socket));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

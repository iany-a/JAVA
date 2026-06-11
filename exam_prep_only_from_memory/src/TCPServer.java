import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000;
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Started multithreading server on port " + port);
            while(true){
                threadPool.execute(new ClientHandler(serverSocket.accept()));
                System.out.println("Accepted incoming connection.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

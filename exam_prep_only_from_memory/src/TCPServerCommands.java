import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServerCommands {
    public static List<Vehicle> globalInventory = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        int port = 5000;
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        try{
            List<Vehicle> vehicles = Utils.readFromFile(Utils.workingFile);
            globalInventory.addAll(vehicles);
            System.out.println("Loaded global inventory");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("TCP Command server started");
            while(true){
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new CommandsHandler(clientSocket, threadPool));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

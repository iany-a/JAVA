import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
       try{
           List<Vehicle> list = Utils.deserializeFromStream(socket.getInputStream());
           System.out.println("Received list from input stream. Deserialized into local list");
           System.out.println(list);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}

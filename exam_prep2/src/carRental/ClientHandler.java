package carRental;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket handlerSocket;

    public ClientHandler(Socket handlerSocket) {
        this.handlerSocket = handlerSocket;
    }

    @Override
    public void run() {
        try{
            List<Vehicle> listReceived = Utils.deserializeFromStream(handlerSocket.getInputStream());
            System.out.println("Car list received and deserialized in memory.");
            System.out.println(listReceived);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try{
                if (handlerSocket != null && !handlerSocket.isClosed()){
                    handlerSocket.close();
                    System.out.println("Socket closed.");
                }
            } catch (IOException ignored) {
            }
        }
    }
}

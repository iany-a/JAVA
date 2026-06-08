package subjects.airplane.server;

import subjects.airplane.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String uniqueFileName = "ReceivedAirplane" + System.currentTimeMillis()+Thread.currentThread().getId()+".ser";
        String destinationPath = Utils.filePathServer + uniqueFileName;
        try (InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOut = new FileOutputStream(destinationPath)) {
            System.out.println("Receiving file from client...");

            byte[] buffer = new byte[8192];
            int bytesRead;

            while((bytesRead = inputStream.read(buffer))!= -1){
                fileOut.write(buffer, 0, bytesRead);
            }

            System.out.println("File received and saved to: " + destinationPath);
            Utils.deserialize(destinationPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

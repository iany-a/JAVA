package subjects.airplane.server;

import subjects.airplane.Utils;

import java.io.*;
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
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(destinationPath))) {
            System.out.println("Receiving file from client...");

            bufferedInputStream.transferTo(fileOut);
            fileOut.flush();

            System.out.println("File received and saved to: " + destinationPath);
            Utils.deserialize(destinationPath);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

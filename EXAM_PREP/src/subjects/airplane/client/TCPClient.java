package subjects.airplane.client;

import subjects.airplane.Airplane;
import subjects.airplane.AirplaneType;
import subjects.airplane.ExpenseManager;
import subjects.airplane.Utils;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    private String hostname;
    private int port;

    public TCPClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void sendFile(String filePath){
        try (BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(filePath));
             Socket socket = new Socket(this.hostname, this.port);
             BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream())) {
            System.out.println("Connected to server using port " + port);

            fileIn.transferTo(out);
            out.flush();
            System.out.println("File sent to server.");

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExpenseManager e1 = new ExpenseManager(2000, 500, 200, 300);
        ExpenseManager e2 = new ExpenseManager(2400, 800, 300, 500);
        Airplane a1 = new Airplane(e1, "01", AirplaneType.AIRBUS);
        Airplane a2 = new Airplane(e2, "02", AirplaneType.BOEING);

        System.out.println(a1.toString());

        Utils.serialize(a1, Utils.filePathClient + "AirplaneExpenses1.ser");
        Utils.serialize(a2, Utils.filePathClient + "AirplaneExpenses2.ser");
        TCPClient client = new TCPClient("localhost", 5000);
        client.sendFile(Utils.filePathClient + "AirplaneExpenses1.ser");
        client.sendFile(Utils.filePathClient + "AirplaneExpenses2.ser");


    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientCommands {
    private int port;
    private String hostname;

    public TCPClientCommands(int port, String hostname) {
        this.port = port;
        this.hostname = hostname;
    }

    public static void main(String[] args) {
        TCPClientCommands client = new TCPClientCommands(5000, "localhost");
        try(Socket socket = new Socket(client.hostname, client.port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String command = "AVAILABLE BUCHAREST";

            System.out.println("Sending command: " + command);
            writer.println(command);


            String response;
            while((response = in.readLine())!= null){
                System.out.println("Server reply -> " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

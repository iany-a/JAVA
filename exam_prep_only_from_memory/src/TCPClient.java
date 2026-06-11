//import java.io.IOException;
//import java.net.Socket;
//import java.util.List;
//
//public class TCPClient {
//
//    private int port;
//    private String hostname;
//
//    public TCPClient(int port, String hostname) {
//        this.port = port;
//        this.hostname = hostname;
//    }
//
//    public void sendListToServer(String pathTxt){
//        try(Socket socket = new Socket(this.hostname, this.port)){
//            List<Vehicle> list = Utils.readFromFile(pathTxt);
//            System.out.println("Converted text input file to list.");
//            Utils.serializeToStream(socket.getOutputStream(), list);
//            System.out.println("Sent list to server.");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        TCPClient client = new TCPClient(5000, "localhost");
//        client.sendListToServer(Utils.workingFile);
//        System.out.println("DONE");
//    }
//}

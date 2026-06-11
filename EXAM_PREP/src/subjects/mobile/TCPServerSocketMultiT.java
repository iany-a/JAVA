package subjects.mobile;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class TCPServerSocketMultiT {
    private int port = 50001;
    private File f;
    ServerSocket serverSocket;
    private VectThread vt;

    public TCPServerSocketMultiT(int port) throws Exception {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
    }

    public void setFileName(String newFName){
        if (newFName == null) throw new UnsupportedOperationException("Invalid input.");
        this.f = new File(newFName);
    }

    public void startTCPServer() throws IOException{
        try(ServerSocket serverSocket1 = new ServerSocket(this.port)){
            while(true){
                Utils.writeBinaryPhones(Utils.directory + "output.ser", Utils.readPhones(Utils.directory + "input.txt"));
                //i don't fucking know what this shit is
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

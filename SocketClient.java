import java.io.*;
import java.net.*;
import java.util.*;

public class SocketClient {
    public static void main(String[] args) {
        SocketClient sample = new SocketClient();
        sample.sendSocket();
    }

    public void sendSocket() {
        for(int i=0;i<3;i++){
            sendSocketData("Hello world! I'm client "+new Date());
        }
        sendSocketData("EXIT");
    }

    public void sendSocketData(String data) {
        Socket socket = null;
        try {
            System.out.println("Client: Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client: Connect Status: = "+socket.isConnected());
            Thread.sleep(1000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client: Sent data");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

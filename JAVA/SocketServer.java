import java.io.*;
import java.net.*;

public class SocketServer {
    public static void main(String[] args) {
        SocketServer sample = new SocketServer();
        sample.startServer();
    }

    public void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while(true) {
                System.out.println("port 9999 Server is waiting for request");
                client = server.accept();
                System.out.println("Server: Accepted");
                InputStream stream = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                String data = null;
                StringBuilder receivedData = new StringBuilder();
                while((data = br.readLine()) != null) {
                    receivedData.append(data);
                }
                System.out.println("Received Data : "+receivedData);
                br.close();
                stream.close();
                client.close();
                if(receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("-------------------");
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

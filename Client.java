import java.util.*;
 import java.io.*;
 import java.net.*;

public class Client {
    public void run () throws UnknownHostException, IOException {

        int port =8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toSocket =new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromSocket =new BufferedReader(new InputStreamReader(socket.getInputStream()));
 toSocket.println("hello from the client");
 String  line = fromSocket.readLine();
 System.out.println("response from the server is :"+line);
 toSocket.close();
 fromSocket.close();
 socket.close();




    }

    public static void main(String[] args) {
        try{
            Client client = new Client();
            client.run();
        }catch(Exception ex){ex.printStackTrace();}
    }
}



import java.io.*;
import java.net.*;





public class Server {

public void run() throws IOException {

    int port =8010;
    ServerSocket socket =  new ServerSocket(port);
    socket.setSoTimeout(1000000);
    while(true){
    try{
        System.out.println( "serve is listening on port "+ port);
        Socket  acceptedConnection=socket.accept();
        System.out.println("connection accepted from client"+acceptedConnection.getRemoteSocketAddress());
        PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(),true);
        BufferedReader fromClient=new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
        String clientMessage = fromClient.readLine();
        System.out.println("Client says: " + clientMessage);

        toClient.println("Hello Client  how  do u do ");
        toClient.close();
        fromClient.close();
        acceptedConnection.close();
        
    }catch(IOException ex){
       ex.printStackTrace();
    }
    }



}
    public static void main(String[] args) {
Server server = new Server();
try{

    server.run();
}catch(Exception ex){
    ex.printStackTrace();

}
    }
}
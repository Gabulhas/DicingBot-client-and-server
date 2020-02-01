package server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {

    public static ArrayList<Connection> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3500);
        Socket socket = null;
        System.out.println("Starting on port: "+server.getLocalPort());
        Connection newConn=null;
        while(true){
            try {

                socket = server.accept();

                newConn = new Connection( new DataOutputStream(socket.getOutputStream()),System.currentTimeMillis());
                list.add(newConn);
                System.out.println("User Connected");
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client.client
           // sendOut.broadcast("User Connected: "+newConn.getUserNumber(),list,newConn);
            new EchoThread(socket,newConn).start();
        }



    }

}

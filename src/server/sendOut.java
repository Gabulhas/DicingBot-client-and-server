package server;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class sendOut {

    /*
    public static void send(String mess, ArrayList<PrintStream> list){
        for(PrintStream client.client:server.Server.list){

            client.client.println(mess);
        }

    }*/

    public static void broadcast(String mess, ArrayList<Connection> list, Connection connEx) throws IOException {
       /* for(Connection client:Server.list){



          if(!client.getUserNumber().equals(connEx.getUserNumber())){
                client.getOutput().writeBytes(mess);
}
        }*/

    }
    public static void broadcast(String mess, ArrayList<Connection> list){
        for(Connection client:Server.list){




                //client.getPrintStream().println(mess);

        }

    }

}

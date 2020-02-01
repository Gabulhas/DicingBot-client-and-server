package server;


import org.json.*;
import server.Messages.LoginMessage;
import server.Messages.MuleRequest;

import java.io.PrintStream;

public class messageTypeHandler {



    public static void on(String type, JSONObject msg,Connection connection) throws JSONException {
        System.out.println(msg.toString());
        switch (type){
            case "Login":
                LoginMessage.add(msg,connection);
                System.out.println(Server.list);




                break;


            case "MuleRequest":


                    MuleRequest muleRequest = new MuleRequest(connection,msg);
                    new Thread(muleRequest).start();


                break;

            case "DicerKill":



                break;









        }




    }
}

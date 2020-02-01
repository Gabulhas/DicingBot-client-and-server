package server.Messages;


import org.json.*;
import server.Connection;
import server.Server;

public class LoginMessage {

    public static void add(JSONObject obj,Connection connection) throws JSONException {


        for(Connection d:Server.list){

            if(d.getUsername().equals(obj.getString("Username"))){
                d.setOutput(connection.getOutput());
                d.setUsername(obj.getString("Username"));
                d.setWorld(obj.getInt("World"));
                d.setBotType(obj.getString("BotType"));
                System.out.println("Bot Logged------\nName: "+connection.getUserNumber()+"\nWorld: "+connection.getWorld()+"\nType: "+connection.getBotType());
            }
            if(d.getOutput().equals(connection.getOutput())){


                d.setOutput(connection.getOutput());
                d.setUsername(obj.getString("Username"));
                d.setWorld(obj.getInt("World"));
                d.setBotType(obj.getString("BotType"));
                System.out.println("Bot Logged------\nName: "+connection.getUserNumber()+"\nWorld: "+connection.getWorld()+"\nType: "+connection.getBotType());
            }


            if(d.getUserNumber().equals(connection.getUserNumber())){



                d.setUsername(obj.getString("Username"));
                d.setWorld(obj.getInt("World"));
                d.setBotType(obj.getString("BotType"));
                System.out.println("Bot Logged------\nName: "+d.getUserNumber()+"\nWorld: "+d.getWorld()+"\nType: "+d.getBotType());
            }
        }




    }


}

package server.Messages;

import org.json.JSONException;
import org.json.JSONObject;
import server.Connection;
import server.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;

public class MuleRequest implements Runnable{
    private Connection c;
    private JSONObject j;

    public MuleRequest (Connection c, JSONObject j) {
        this.c=c;
        this.j=j;
    }
/*
    public static void find(Connection c, JSONObject j) throws JSONException, InterruptedException, IOException {

        boolean flag = true;

        for(Connection d: Server.list){
            if(d.getBotType().equals("Mule")&&flag){

                JSONObject muleResponse = new JSONObject();

                Thread.sleep(500);
                muleResponse.put("type","MuleResponse");
                muleResponse.put("MuleName",d.getUsername());
                System.out.println("Sending \n"+muleResponse.toString()+ " to "+c.getUsername());
                DataOutputStream f2 =c.getOutput();


                f2.writeBytes(muleResponse.toString());
                f2.flush();


            }


        }



    }*/


    @Override
    public void run() {
        boolean flag = true;

        for(Connection d: Server.list){
            if(d.getBotType().equals("Mule")&&flag){

                PrintStream a = new PrintStream(d.getOutput());
                a.flush();
                a.print(j.toString());
                a.flush();



                JSONObject muleResponse = new JSONObject();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    muleResponse.put("type","MuleResponse");
                    muleResponse.put("MuleName",d.getUsername());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                PrintStream f =new PrintStream(c.getOutput());

                f.flush();

               f.println(muleResponse.toString());

                f.flush();


                System.out.println("Sending Muling request from"+c.getUsername()+" to: "+d.getUsername());
                System.out.println("Sending \n"+muleResponse.toString()+ " to "+c.getUsername());

            }


        }


    }

    }

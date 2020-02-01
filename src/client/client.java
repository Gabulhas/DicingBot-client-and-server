package client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
public class client {



    public static void main(String[] args)
            throws IOException, JSONException {
        Socket client=null;
        try {
            client = new Socket("127.0.0.1", 3500);
            System.out.println("Client Connected");
        }
        catch (ConnectException e){
            System.out.println("Couldn't connect to main server");

        }
        assert client != null;
        Receiver r = new Receiver(client.getInputStream());
        new Thread(r).start();


        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(client.getOutputStream());

        JSONObject obj = new JSONObject();
        boolean x=true;
        obj.put("type","Login");
        obj.put("World", 0);
        obj.put("Username","test");
        obj.put("BotType","Bot");
        saida.println(obj.toString());
        obj = new JSONObject();
        obj.put("type","MuleRequest");
        obj.put("World", 0);
        obj.put("Username","test");
        obj.put("Profit",2000);
        saida.println(obj.toString());
        while(true &&x){


            saida.println(teclado.nextLine());




        }
        saida.println(obj.toString());


        saida.close();
        teclado.close();
        client.close();
    }

}

package server;

import org.json.*;
import java.io.*;
import java.net.Socket;


public class EchoThread extends Thread {
    protected Socket socket;
    protected Connection connection;

    public EchoThread(Socket clientSocket, Connection connection) {
        this.socket = clientSocket;
        this.connection=connection;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null&&false)) {
                    socket.close();
                    return;
                } else {

                    JSONObject obj = new JSONObject(line);

                    System.out.println("Received: "+obj.getString("type")+" request.");
                    messageTypeHandler.on(obj.getString("type"),obj,this.connection);
                   // broadcast.broadcast(line,server.Server.list,connection);

                }





            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
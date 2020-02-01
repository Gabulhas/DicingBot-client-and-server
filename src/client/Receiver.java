package client;

import java.io.InputStream;
import java.util.Scanner;

public class Receiver implements Runnable {
    private InputStream server;

    public Receiver(InputStream server){

        this.server=server;
    }



    @Override
    public void run() {
        Scanner s = new Scanner(this.server);
        System.out.println("Listener running.");
        while(s.hasNextLine()){

            System.out.println(s.nextLine());

        }
        s.close();
    }
}

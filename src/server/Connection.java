package server;

import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Connection {
   private OutputStream printStream;
    private Long userNumber;
    private String username="";
    private int world=-1;
    private String botType ="";

    public String getBotType() {
        return botType;
    }

    public void setBotType(String botType) {
        this.botType = botType;
    }

    public int getWorld() {
        return world;
    }

    public void setWorld(int world) {
        this.world = world;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Connection(DataOutputStream printStream, Long userNumber) {
        this.printStream = printStream;
        this.userNumber = userNumber;
    }

    public OutputStream getOutput() {
        return printStream;
    }

    public void setOutput(OutputStream printStream) {
        this.printStream = printStream;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "OutputStream=" + printStream +
                ", userNumber=" + userNumber +
                ", username='" + username + '\'' +
                ", world=" + world +
                ", botType='" + botType + '\'' +
                '}';
    }
}

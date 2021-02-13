package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class ServerEchoer extends Thread {

    @Override
    public void run() {
            BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        try {

            while(true){
                System.out.println("Enter string to be echoed: ");
                String messageFromServer = keyboardInput.readLine();
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
                messageFromServer = timeStamp + " Message from server:" + messageFromServer ;
                for(ClientThread clientThread : Main.connectedClients){
                    PrintWriter output = new PrintWriter(clientThread.getSocket().getOutputStream(), true);
                    output.println(messageFromServer);
                }
                }
        } catch(IOException e){
            System.out.println("Oops: " + e.getMessage());
        }
    }
}

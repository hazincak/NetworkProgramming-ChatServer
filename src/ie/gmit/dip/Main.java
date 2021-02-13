package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<ClientThread> connectedClients = new ArrayList<>();

    public static void main(String[] args) {
        int portNumber;
        portNumber = portNumber();
        startServer(portNumber);
    }
    public static void startServer(int port){
        System.out.println("Starting server on port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)){
        ServerEchoer serverEchoer = new ServerEchoer();
        serverEchoer.start();

            while(true){
                 ClientThread client = new ClientThread(serverSocket.accept());
                 client.start();
                 connectedClients.add(client);

            }
        } catch (IOException e){
            System.out.println("Server exception " + e.getMessage());
        }
    }


    public static int portNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select a port number for your server (5000 - 65,535 inclusive)");
        String portString = input.nextLine();
        int portNumber = 0 ;
        boolean portNumberValid = false;
        while(true){
            try{
                portNumber = Integer.parseInt(portString);
                if(portNumber >=5000 && portNumber <= 65535){
                    System.out.println("Port number of the server set to " + portNumber);
                    break;
                }else if(portNumber < 5000){
                    System.out.println("Please use port number higher than 5000");
                }else if (portNumber > 65535) {
                    System.out.println("Port number cannot be higher than 65535");
                }
                System.out.println("Select a port number for your server (5000 - 65,535 inclusive)");
                portString = input.nextLine();

            } catch (NumberFormatException e){
                System.out.println("Invalid port number");
                System.out.println("Try again");
                portString = input.nextLine();
            }
        }
        return portNumber;
    }
}

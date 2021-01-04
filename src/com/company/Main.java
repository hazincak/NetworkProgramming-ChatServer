package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int portNumber;
        int menuChoice;

        menuChoice = menu();
        if(menuChoice != 0){
            portNumber = portNumber();
            try (ServerSocket serverSocket = new ServerSocket(portNumber)){
                while(true){
                    new Messenger(serverSocket.accept()).start();
                }
            }catch (IOException e){
                System.out.println("Server error " + e.getMessage());
            }
        }
    }

    public static int menu(){
        Scanner input = new Scanner(System.in);
        int selection;


        System.out.println("Welcome to ChatServer configuration.");
        System.out.println("Select your option");
        System.out.println("-------------------------\n");
        System.out.println("1 - Create a server");
        System.out.println("2 - Quit");

        selection = input.nextInt();
        return selection;
    }

    public static int portNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select a port number for your server (0 - 65,535 inclusive)");
        String portString = input.nextLine();
        int portNumber = 0 ;
        boolean portNumberValid = false;

        while(true){
            try{
                portNumber = Integer.parseInt(portString);
                if(portNumber >=0 && portNumber <= 65535){
                    System.out.println("Port number of the server set to  " + portNumber);
                    break;
                }else if(portNumber < 0){
                    System.out.println("Port cannot be a negative number");
                }else if (portNumber > 65535) {
                    System.out.println("Port number cannot be higher than 65535");
                }
                System.out.println("Select a port number for your server (0 - 65,535 inclusive)");
                portString = input.nextLine();

            } catch (NumberFormatException e){
                System.out.println("Invalid portnumber");
                System.out.println("Try again");
                portString = input.nextLine();
            }
        }
        return portNumber;
    }

}

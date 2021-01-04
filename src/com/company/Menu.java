package com.company;


import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    public int menu(){

        int selection;


        System.out.println("Welcome to ChatServer configuration.");
        System.out.println("Select your option");
        System.out.println("-------------------------\n");
        System.out.println("1 - Create a server");
        System.out.println("2 - Quit");

        selection = input.nextInt();
        return selection;
    }

    public int portNumber(){
        System.out.println("Select a port number for your server (0 - 65,535 inclusive)");
        String portString = input.nextLine();
        int portNumber = 0 ;
        boolean portNumberValid = false;

        while(!portNumberValid){
            try{
                portNumber = Integer.parseInt(portString);
                portNumberValid = true;
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
                portNumberValid = false;
            }
        }




//        if(input.hasNextInt()){
//            port = input.nextInt();
//            if(port < 0 || port > 65535){
//                System.out.println("invalid input");
//            }else if(!input.hasNextInt()){
//                System.out.println("invalid input");
//            }
//        };

        return portNumber;
    }

}

# NetworkProgramming-ChatServer

## Description
This project is part of a simple network-based chat application.

## Server description
The *ChatServer* program needs to run first. It’s main task is to create a server, listen for connecting clients and handling all messages. 
Server is created in the *Main* class where a main (runner) method is located. User is given an option to pick up a port number on which the created server will run.
Port number can be selected within range 5000 up to 65 535. The server will start after the user selects a valid port number. 
User is returned to correct his selection if the entered input contains either a number smaller than 5000, bigger than 65 535, or any other Java data type than Integer. 
After this configuration, the server is ready to receive incoming connections. 
This server is a multithreaded server, therefore, it can handle communication with multiple clients. 
Each new incoming connection represented by a new client creates a new *ClientThread* object which runs concurrently with other connected clients. 


## How to run
1.	Enter the *ChatServer* folder and navigate to the java file directory with the following command:
```cd src/ie/gmit/dip```
2. Compile all files:
```javac Main.java ServerEchoer.java ```
3. Type *ls* command (Windows PowerShell or Git Bash) or *dir* command (Command Prompt) to ensure that you have all your compiled files ending with *.class*
4. Return to the *src* directory and execute the following command to run the application:
```java ie.gmit.dip.Main```

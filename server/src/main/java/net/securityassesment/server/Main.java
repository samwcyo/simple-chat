package net.securityassesment.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        //declare port to run server on
        Integer port = 1337;

        try{

            //pre definitions
            String clientsMessage;
            String returned;

            //define sockets, scanner, and reader for sending custom message
            ServerSocket s1 = new ServerSocket(port);
            Socket ss = s1.accept();
            Scanner sc = new Scanner(ss.getInputStream());
            Scanner reader = new Scanner(System.in);

            while(true) {
                //print clients message
                clientsMessage = sc.nextLine();
                System.out.println("client@localhost~" + clientsMessage);
                //asks the server to send a message back
                System.out.print("server@localhost~ ");
                returned = reader.nextLine();
                //print to the client
                PrintStream p = new PrintStream(ss.getOutputStream());
                p.println("server@localhost~ " + returned);
            }

        } catch(Exception ex) {
            System.out.println("Error communicating with client and/or starting server...");
        }

    }

}

package net.securityassesment.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        //connection details
        String serverAddress = "127.0.0.1";
        Integer port = 1337;

        try{

            //pre definitions
            String message, temp;
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket(serverAddress, port);
            Scanner sc1 = new Scanner(s.getInputStream());

            while(true) {
                //read/prepare custom message
                System.out.print("client@localhost- ");
                message = sc.nextLine();
                //send message to server
                PrintStream p = new PrintStream(s.getOutputStream());
                p.println(message);
                //wait for message and print back from server
                temp = sc1.nextLine();
                System.out.println(temp);
            }

        } catch(Exception ex) {
            System.out.println("Error communicating with server...");
        }

    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package howdoinetwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class MessageSender implements Runnable {

    private String name;
    
    PrintWriter writer;
    
    public MessageSender(String name, PrintWriter writer) {
        this.name = name;
        this.writer = writer;
    }
    
    @Override
    public void run() {
        
        Scanner myScanner = new Scanner(System.in);
        String readString = "Hello!";

        while (!readString.equals("done") && writer != null) {
            readString = myScanner.nextLine();
            writer.println(readString);
            System.out.println("Sent from "+name+": "+readString);
        }
        System.out.println(name+" is done!");
    }
    
}

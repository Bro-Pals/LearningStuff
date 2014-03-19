/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package howdoinetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author Owner
 */
public class HowDoINetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Running server");
        
        boolean alive = true;
        
        final int portNumber = 55341;
        
        try {
            ServerSocket myFirstServerSocket = new ServerSocket(portNumber);
            Socket clientSocket = myFirstServerSocket.accept();
            
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            System.out.println("Looks like we have a server now at port "+portNumber);
            String outsideMessage = "";

            while (outsideMessage != null) {
                outsideMessage = reader.readLine();
                System.out.println("From Client: "+outsideMessage);
            }
            
            System.out.println("finish!");
        } catch(IOException e) {
            System.err.println("IO Exception: "+e.toString());
        } catch(SecurityException e) {
            System.err.println("Security Exception!: "+e.toString());
        } catch(Exception e) {
            System.err.println(e.toString());
        }
        
    }
}

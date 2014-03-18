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

/**
 *
 * @author Owner
 */
public class HowDoIClientSide {
    
    public static void main(String[] args) {
        
        String hostName = "Not Found";
        
        // find the host name (thanks stack overflow)
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostName = address.getHostName();
        } catch(UnknownHostException e) {
            System.err.println("Could not get host name "+e.toString());
        }

        final int portNumber = 55341;
        
        try {
            Socket aSocket = new Socket(hostName, portNumber);
            PrintWriter writer = new PrintWriter(aSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
        } catch(UnknownHostException e) {
            System.err.println(e.toString());
        } catch(Exception e) {
            System.err.println(e.toString());
        }
    }
}

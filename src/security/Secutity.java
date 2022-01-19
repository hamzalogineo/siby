/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author hp
 */
public class Secutity {
    
    public static void main(String[] args) throws SocketException {
        
            int cpu = Runtime.getRuntime().availableProcessors() ;
                System.out.println(String.valueOf(cpu)) ;
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
while (nis.hasMoreElements()) {
    NetworkInterface ni = nis.nextElement();
    System.out.println(ni.getName() + " " + ni.getDisplayName());
}
            
            
    }
    
}

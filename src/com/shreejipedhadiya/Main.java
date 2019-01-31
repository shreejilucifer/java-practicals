package com.shreejipedhadiya;

import java.net.InetAddress ;
import java.net.UnknownHostException ;

public class Main {

    public static void main(String[] args) {

        try{

            InetAddress ip = InetAddress.getLocalHost();

            System.out.println( "Host Name: " + ip.getHostName() );
            System.out.println( "IP Address: " + ip.getHostAddress() );
            System.out.println( "Loopback Address :" + ip.getLoopbackAddress() );
            System.out.println( "Canonical HostName :" + ip.getCanonicalHostName() );

        } catch (UnknownHostException e) {

            System.out.println(e);

        }

    }
}

package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            
            System.out.println( "Server in avvio" );
            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept(); //aspetta che qualcuno si colleghi alla porta 3000 per fare il socket per parlare e ascoltare, una volta collegato qualcuno apre un altra porta per liberare la 3000
            
            System.out.println( "Un client si è collegato" );

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringaRicevuta = in.readLine();
            System.out.println( "Stringa ricevuta: "+stringaRicevuta );

            String stringaMaiuscola = stringaRicevuta.toUpperCase();

            out.writeBytes(stringaMaiuscola+'\n');

            s.close();
            server.close();

        } catch (Exception e) {
            System.out.println( e.getMessage() );
            System.out.println( "Errore durante l'istanza del server" );
        }

    }
}

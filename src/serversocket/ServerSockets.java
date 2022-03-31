/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 17mar
 */
public class ServerSockets {

    public static void main(String args[]) {
        try {
            ServerSocket sk = new ServerSocket(7);
            while (true) {
                try (Socket cliente = sk.accept()) {
                    BufferedReader entrada = new BufferedReader(
                            new InputStreamReader(cliente.getInputStream()));
                    PrintWriter salida = new PrintWriter(
                            new OutputStreamWriter(cliente.getOutputStream()), true);
                    String datos = entrada.readLine();
                    salida.println(datos);
                    System.out.println(datos);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}



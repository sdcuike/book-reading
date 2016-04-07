package com.doctor.ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月7日 下午11:50:16
 * 
 *         Creating a simple echo server
 */
public class SimpleEchoServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 6666;
        System.out.println(" a simple echo server");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("a client have connected");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);) {
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    System.out.println("client send : " + inputLine);
                    pw.println(inputLine);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO:
        }

    }

}

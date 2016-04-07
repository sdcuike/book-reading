package com.doctor.ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月8日 上午12:00:25
 * 
 *         Creating a simple echo client
 */
public class SimpleEchoClient {

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("simple echo client");
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("waiting for connect to server :" + localHost);

        try (Socket socket = new Socket(localHost, 6666);
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));) {

            System.out.println("connected to server" + localHost);

            try (Scanner scanner = new Scanner(System.in)) {

                while (true) {
                    String inputLine = scanner.nextLine();
                    if ("q".equalsIgnoreCase(inputLine)) {
                        break;
                    }
                    pw.println(inputLine);
                    String readLine = br.readLine();
                    System.out.println("Server response:" + readLine);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

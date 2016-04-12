package com.doctor.ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月12日 下午9:48:30
 */
public class Java8EchoServer {

    public static void main(String[] args) {
        int port = 6666;
        System.out.println(" a simple echo server");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("a client have connected");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);) {

                Supplier<String> socketInput = () -> {
                    try {
                        return br.readLine();
                    } catch (Exception e) {
                        return null;
                    }
                };

                Stream.generate(socketInput).map(s -> {
                    System.out.println("client send :" + s);
                    pw.println(s);
                    return s;
                }).allMatch(s -> s != null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO:
        }

    }

}

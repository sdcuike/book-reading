package com.doctor.ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月12日 下午9:59:26
 */
public class Java8EchoClient {

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

                Supplier<String> input = () -> scanner.nextLine();
                Stream.generate(input).map(s -> {
                    pw.println(s);
                    try {
                        System.out.println("Server response:" + br.readLine());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    return s;
                }).allMatch(s -> !s.equals("q"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

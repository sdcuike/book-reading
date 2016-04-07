package com.doctor.ch01;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月7日 下午11:35:49
 * 
 *         Network addressing using the InetAddress class
 */
public class NetworkAddressingUsingTheInetAddress {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("www.packtpub.com");

        System.out.println(inetAddress);// www.packtpub.com/83.166.169.231

        System.out.println(inetAddress.getHostAddress());// 83.166.169.231

        System.out.println(inetAddress.getHostName());// www.packtpub.com

        System.out.println(inetAddress.isReachable(600000));

        System.out.println(inetAddress.getCanonicalHostName());// 83.166.169.231

    }

}

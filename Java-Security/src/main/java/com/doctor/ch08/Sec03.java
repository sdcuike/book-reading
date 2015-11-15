package com.doctor.ch08;

import java.security.Provider;
import java.security.Security;
import java.util.stream.Stream;

/**
 * 
 * @author sdcuike
 *
 * @time 2015年11月15日 下午11:36:10
 */
public class Sec03 {

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();

        Stream.of(providers).forEach((Provider p) -> System.err.println(p));

    }

}

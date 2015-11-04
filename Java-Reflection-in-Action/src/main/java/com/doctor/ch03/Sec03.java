package com.doctor.ch03;

import java.lang.reflect.Array;
import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 * @time 2015年11月4日 下午10:58:29
 */
public class Sec03 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] newInstance = (String[]) Array.newInstance(String.class, 6);
        System.out.println(newInstance.length);
        Stream.of(newInstance).forEach(System.out::println);
    }

}

package com.doctor.java8;

import java.util.Arrays;
import java.util.Locale;

/**
 * The Locale Class
 * 
 * @author sdcuike
 *
 *         Created on 2016年3月5日 下午4:40:32
 */
public class TheLocaleClass {

    public static void main(String[] args) {
        System.out.println("The default locale" + Locale.getDefault());
        Locale[] availableLocales = Locale.getAvailableLocales();
        Arrays.stream(availableLocales).forEach(t -> System.out.println(t + " :" + t.getDisplayName()));
    }

}

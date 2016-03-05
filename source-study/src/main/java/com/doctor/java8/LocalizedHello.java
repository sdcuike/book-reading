package com.doctor.java8;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ResourceBundle class
 * 
 * @author sdcuike
 *
 *         Created on 2016年3月5日 下午5:20:29
 */
public class LocalizedHello {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourceBundle", locale);
        System.out.println(resourceBundle.getString("Greeting"));
    }

}

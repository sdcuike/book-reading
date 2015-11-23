package com.doctor.java8;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * internationalize your applications
 * 
 * @author sdcuike
 *
 * @time 2015年11月22日 下午5:20:01
 * 
 *       <<Pro_Java_8_Programming_(3rd_edition)>>
 * 
 *       To be able to internationalize your applications, you’ll need to know about the following topics:
 *       • Locales
 *       • Resource bundles
 *       • Formatting and parsing
 */
public class InternationalizingYourApplications {

    public static final String propFile = "java8/resourceTest";

    public static void main(String[] args) {
        Stream.of(Locale.getAvailableLocales()).forEach(System.out::println);
        System.out.println(Locale.CHINA.getCountry() + Locale.CHINA.getDisplayName());

        ResourceBundle bundle = ResourceBundle.getBundle(propFile, Locale.ENGLISH);
        System.out.println(bundle.getString("WhatIsJava"));
        System.out.println(bundle.getString("JavaIsLang"));
        System.out.println(bundle.getClass());// class java.util.PropertyResourceBundle

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.CHINA);
        System.out.println(numberFormat.format(123.56785D));// 123.568
        System.out.println(NumberFormat.getInstance(Locale.ENGLISH).format(123.56785D));// 123.568

    }

}

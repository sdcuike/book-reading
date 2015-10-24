package com.doctor.ch13;

import java.util.Locale;
import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 * @time 2015年10月25日 上午00:34:17
 */
public class Sec01 {

	public static void main(String[] args) {

		Stream.of(Locale.getAvailableLocales()).forEach(System.out::println);
	}

}

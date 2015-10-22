package com.doctor.ch03;

import java.util.Arrays;
import java.util.List;

/**
 * @author sdcuike
 *
 * @time 2015年10月22日 下午4:01:15
 * 
 *       Method References
 * 
 */
public class Sec05 {

	public static void main(String[] args) {
		String[] strings = { "who", "are", "you" };
		String[] strings2 = Arrays.copyOf(strings, strings.length);
		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.toString(strings2));

		Arrays.sort(strings2, (x, y) -> x.compareToIgnoreCase(y));
		Arrays.sort(strings, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.toString(strings2));

		List<String> list = Arrays.asList(strings2);
		list.forEach(x -> System.out.println(x));
		list.forEach(System.out::println);

	}
}

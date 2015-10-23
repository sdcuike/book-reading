package com.doctor.ch08;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 * @time 2015年10月24日 上午12:44:22
 * 
 *       Stream Creation
 */
public class Sec02 {

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 1, 2, 3, 5, 6 };

		Stream.of(array).forEach(System.out::print);
		Stream<Integer> stream = Stream.of(1, 2, 3, 5);
		stream.forEach(System.out::print);

		Stream.of("hello doctor".split(" ")).forEach(System.out::print);

		int[] i = new int[] { 5, 6, 7, 8 };
		Arrays.stream(i).forEach(System.out::print);

		System.out.println();
		Stream.generate(Math::random).limit(19).forEach(System.out::println);

	}
}

package com.doctor.ch08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 * @time 2015年10月24日 上午1:00:39
 */
public class Sec03 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("NAME", "SEX", "ADDRESS");
		list.stream().filter(w -> w.length() > 3).forEach(System.out::println);

		list.stream().map(String::toLowerCase).forEach(System.out::println);
		System.out.println("===========");

		List<String> list2 = Arrays.asList("doctor who", "doctor", "who are you ");
		Stream<Stream<String>> stream = list2.stream().map(w -> Stream.of(w.split("  ")));
		stream.forEach(t -> t.forEach(System.out::println));

		Stream<String> flatMap = list2.stream().flatMap(w -> Stream.of(w.split("  ")));
		System.out.println("===========");
		flatMap.forEach(System.out::println);
	}

}

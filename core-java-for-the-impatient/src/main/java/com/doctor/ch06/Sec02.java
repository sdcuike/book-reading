package com.doctor.ch06;

import java.util.stream.Stream;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午6:07:30
 * 
 *       Generic Methods
 */
public class Sec02 {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 2, 3 };
		System.out.println("============");
		Stream.of(array).forEach(System.out::println);

		Sec02.swap(array, 0, 1);
		System.out.println("============");

		Stream.of(array).forEach(System.out::println);

		Sec02.<Integer> swap(array, 1, 2);
		System.out.println("============");
		Stream.of(array).forEach(System.out::println);
	}

	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}

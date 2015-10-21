package com.doctor.ch01;

import java.math.BigInteger;

/**
 * @author sdcuike
 *
 * @time 2015年10月21日 下午6:50:09
 */
public class Sec08 {

	public static void main(String[] args) {
		int[] a = new int[2]; // 自动初始化0
		for (int i : a) {
			System.out.println(i);// 0
		}

		BigInteger[] bigIntegers = new BigInteger[2]; // 初始化为null
		for (BigInteger bigInteger : bigIntegers) {
			System.out.println(bigInteger); // null
		}

		// 当然数组长度也可以为0,主要为了返回值的一致性，函数返回集合最好不用null，而是返回空集合
		int[] b = new int[0];
		// or
		b = new int[] {};
		System.err.println(b.length); // 0

		for (int i : b) {
			// 不会执行
			System.out.println(i);
		}
	}

}

package com.doctor.ch01;

/**
 * @author sdcuike
 *
 * @time 2015年10月21日 下午5:22:14
 */
public class Sec02 {
	int i;
	static int j;

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE); // 有正负之分
		String unsignedString = Integer.toUnsignedString(Integer.MIN_VALUE);
		System.out.println(unsignedString);

		System.out.println(Double.isNaN(0.0 / 0.0)); // true
		System.out.println(Double.isInfinite(10.0 / 0.0)); // true

		// 区分实例变量 、静态变量、局部变量的初始话（编译器实现）
		System.out.println(Sec02.j); // 0
		System.out.println(new Sec02().i); // 0
		int ii;
		// System.out.println(ii); java.lang.Error ,The local variable ii may not have been initialized

	}
}

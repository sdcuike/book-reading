package com.doctor.ch01;

/**
 * @author sdcuike
 *
 * @time 2015年10月21日 下午6:21:59
 */
public class Sec05 {

	public static void main(String[] args) {
		// jdk8字符串拼接新方法,底层实现还是我们之前经常用的StringBuilder，
		// 对于大量的字符串拼接，这个效率还是没那么高，我们必须显示的用StringBuilder解决（老方法）
		String join = String.join("=", "name", "doctor");
		System.out.println(join);

	}

}

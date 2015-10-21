package com.doctor.ch01;

/**
 * @author sdcuike
 *
 * @time 2015年10月21日 下午5:55:36
 */
public class Sec04 {

	public static void main(String[] args) {
		// 判断整数偶数
		int even = 6;
		if (even % 2 == 0) {
			System.out.println(even + "是偶数");
		}

		// 判断奇数，注意正负,所以一般我们判断偶数就可以，非偶数就是奇数
		int odd = 3;// 奇数
		if (odd % 2 == 1 || odd % 2 == -1) {
			System.out.println(odd + "是奇数");
		}
		odd = -9;
		if (odd % 2 == 1 || odd % 2 == -1) {
			System.out.println(odd + "是奇数");
		}

		try {
			// 避免计算溢出错误
			int multiplyExact = Math.multiplyExact(1_000_000_000, 3);
			System.out.println(multiplyExact);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.doctor.ch05;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午5:10:27
 */
public class Sec01 {

	public static void main(String[] args) {
		// 返回值覆盖现象
		System.out.println(returnTest());// 2
	}

	@SuppressWarnings("finally")
	public static int returnTest() {
		try {
			return 1;
		} catch (Exception e) {

		} finally {
			return 2;
		}

	}
}

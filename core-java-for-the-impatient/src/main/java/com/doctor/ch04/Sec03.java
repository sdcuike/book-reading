package com.doctor.ch04;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午12:17:46
 */
public class Sec03 {

	public static void main(String[] args) {

		Size size = Size.valueOf("SMALL");
		System.out.println(size);

		for (Size s : Size.values()) {
			System.out.println(s);
		}

		// 无实例异常情况
		try {
			Size.valueOf("No");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static enum Size {
		SMALL, MEDIUM, LARGE, EXTRA_LARGE

	}
}

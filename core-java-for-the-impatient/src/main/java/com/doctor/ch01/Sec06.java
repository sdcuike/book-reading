package com.doctor.ch01;

import java.io.Console;
import java.util.Scanner;

/**
 * @author sdcuike
 *
 * @time 2015年10月21日 下午6:35:03
 */
public class Sec06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			System.out.println(scanner.nextInt());
		}

		// 密码输入
		try {
			Console console = System.console();
			char[] readPassword = console.readPassword("password:");
			System.out.println(String.valueOf(readPassword));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.doctor.ch10;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author sdcuike
 *
 * @time 2015年10月24日 下午2:50:08
 */
public class Sec09 {

	public static void main(String[] args) throws IOException {
		Process process = new ProcessBuilder("/bin/ls").start();

		try (Scanner scanner = new Scanner(process.getInputStream())) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}

	}

}

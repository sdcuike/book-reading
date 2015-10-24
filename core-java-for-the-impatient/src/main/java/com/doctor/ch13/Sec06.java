package com.doctor.ch13;

import java.text.MessageFormat;

/**
 * @author sdcuike
 *
 * @time 2015年10月25日 上午12:37:28
 */
public class Sec06 {

	public static void main(String[] args) {
		String template = "{0} has {1} messages";
		String message = MessageFormat.format(template, "Pierre", 66);
		System.out.println(message);
	}

}

package com.doctor.ch12;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * @author sdcuike
 *
 * @time 2015年10月25日 上午12:10:22
 */
public class Sec02 {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.of(1986, Month.DECEMBER, 14));
		System.out.println(LocalDate.now().plus(Period.ofYears(2)));
	}

}

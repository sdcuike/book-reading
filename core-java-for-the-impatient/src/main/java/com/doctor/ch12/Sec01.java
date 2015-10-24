package com.doctor.ch12;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 *
 * @time 2015年10月24日 下午11:56:06
 */
public class Sec01 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Instant.MIN);
		System.out.println(Instant.MAX);
		System.out.println(Instant.now());

		Instant start = Instant.now();
		TimeUnit.SECONDS.sleep(2);
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		System.out.println(duration.getSeconds());
	}

}

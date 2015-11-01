package com.doctor.ch01;

import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 *
 * @time 2015年11月1日 上午9:00:09
 */
public class WaitingForTheFinalization {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "sleep(2)");
		});

		Thread thread2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "sleep(1)");
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();
	}

}

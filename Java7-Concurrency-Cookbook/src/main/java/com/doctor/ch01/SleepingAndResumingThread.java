package com.doctor.ch01;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 *
 * @time 2015年10月31日 下午1:33:32
 */
public class SleepingAndResumingThread {

	public static void main(String[] args) throws InterruptedException {
		FileClock fileClock = new FileClock();
		Thread thread = new Thread(fileClock);
		thread.start();
		TimeUnit.SECONDS.sleep(2);
		thread.interrupt();
	}

	private static class FileClock implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(LocalDateTime.now());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}

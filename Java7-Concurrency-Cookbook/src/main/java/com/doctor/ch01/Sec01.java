package com.doctor.ch01;

/**
 * @author sdcuike
 *
 * @time 2015年10月31日 下午1:10:58
 * 
 *       Creating and running a thread
 */
public class Sec01 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			new Thread(calculator).start();
		}
	}

	public static class Calculator implements Runnable {

		private int number;

		public Calculator(int number) {
			this.number = number;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s: %d: * %d = %d \n", Thread.currentThread().getName(), number, i, i * number);
			}
		}

	}
}

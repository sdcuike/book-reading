package com.doctor.ch06;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Using atomic variables
 * 
 * @author sdcuike
 *
 * @time 2015年11月2日 下午10:04:02
 */
public class UsingAtomicArrays {

	public static void main(String[] args) {
		final int THREADS = 100;
		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(atomicIntegerArray);
		Decrementer decrementer = new Decrementer(atomicIntegerArray);

		Thread[] threadIncrementer = new Thread[THREADS];
		Thread[] threadDecrementer = new Thread[THREADS];

		for (int i = 0; i < THREADS; i++) {
			threadDecrementer[i] = new Thread(decrementer);
			threadIncrementer[i] = new Thread(incrementer);
			threadDecrementer[i].start();
			threadIncrementer[i].start();
		}

		try {
			for (int i = 0; i < THREADS; i++) {
				threadDecrementer[i].join();
				threadIncrementer[i].join();
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < atomicIntegerArray.length(); i++) {
			if (atomicIntegerArray.get(i) != 0) {
				System.out.println("Vector[" + i + "] : " + atomicIntegerArray.get(i));
			}
		}

		System.out.println("Main: End of the example");

	}

	static class Incrementer implements Runnable {
		private AtomicIntegerArray vector;

		public Incrementer(AtomicIntegerArray vector) {
			this.vector = vector;
		}

		@Override
		public void run() {
			int n = vector.length();
			for (int i = 0; i < n; i++) {
				vector.getAndIncrement(i);
			}
		}
	}

	static class Decrementer implements Runnable {
		private AtomicIntegerArray vector;

		public Decrementer(AtomicIntegerArray vector) {
			this.vector = vector;
		}

		@Override
		public void run() {
			int n = vector.length();
			for (int i = 0; i < n; i++) {
				vector.getAndDecrement(i);
			}
		}

	}

}

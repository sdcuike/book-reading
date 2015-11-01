package com.doctor.ch03;

import java.util.concurrent.Semaphore;

/**
 * Controlling concurrent access to a resource
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 下午3:23:08
 */
public class ControllingConcurrentAccessToAResource {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		final int n = 10;
		Thread[] threads = new Thread[n];

		for (int i = 0; i < n; i++) {
			threads[i] = new Thread(new Job(printQueue), "Thread" + i);
		}

		for (int i = 0; i < n; i++) {
			threads[i].start();
		}
	}

	static class Job implements Runnable {
		private PrintQueue PrintQueue;

		public Job(PrintQueue printQueue) {
			this.PrintQueue = printQueue;
		}

		@Override
		public void run() {
			System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
			PrintQueue.printJob(new Object());
			System.out.printf("%s: The document has been printed \n", Thread.currentThread().getName());
		}

	}

	static class PrintQueue {
		private final Semaphore semaphore;

		public PrintQueue() {
			semaphore = new Semaphore(1);
		}

		public void printJob(Object document) {
			try {
				semaphore.acquire();

				long duration = (long) (Math.random() * 10);
				System.out.printf("%s: PrintQueue: Printing a Job during %d	seconds\n", Thread.currentThread().getName(), duration);
				Thread.sleep(duration);

			} catch (InterruptedException e) {

				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
	}

}

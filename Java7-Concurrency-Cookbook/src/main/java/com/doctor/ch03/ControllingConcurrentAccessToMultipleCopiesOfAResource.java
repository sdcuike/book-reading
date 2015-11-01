package com.doctor.ch03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Controlling concurrent access to multiple copies of a resource
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 下午3:44:52
 */
public class ControllingConcurrentAccessToMultipleCopiesOfAResource {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue(3);
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
		private boolean[] freePrinters;
		private final Semaphore semaphore;
		private Lock lockPrinters;
		private int freeNum;

		public PrintQueue(int freeNum) {
			this.freeNum = freeNum;
			semaphore = new Semaphore(this.freeNum);
			freePrinters = new boolean[this.freeNum];

			for (int i = 0; i < this.freeNum; i++) {
				freePrinters[i] = true;
			}

			lockPrinters = new ReentrantLock();
		}

		public void printJob(Object document) {
			try {
				semaphore.acquire();

				int assignedPrinter = getPrinter();
				long duration = (long) (Math.random() * 10);
				System.out.printf("%s: PrintQueue: Printing a Job in Printer	%d during %d seconds\n",
						Thread.currentThread().getName(), assignedPrinter, duration);
				TimeUnit.SECONDS.sleep(duration);
				freePrinters[assignedPrinter] = true;

			} catch (InterruptedException e) {

				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}

		private int getPrinter() {
			int ret = -1;
			try {
				lockPrinters.lock();

				for (int i = 0; i < freePrinters.length; i++) {
					if (freePrinters[i]) {
						ret = i;
						freePrinters[i] = false;
						break;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lockPrinters.unlock();
			}
			return ret;
		}
	}

}

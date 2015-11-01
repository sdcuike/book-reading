package com.doctor.ch01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Creating threads through a factory
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 上午10:24:58
 */
public class CreatingThreadsThroughAFactory {

	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		System.out.println("Starting the Theads \n");
		for (int i = 0; i < 10; i++) {
			Thread thread = factory.newThread(task);
			thread.start();
		}

		System.out.println("Factory stats:");
		System.out.println(factory.getStats());
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static class MyThreadFactory implements ThreadFactory {
		private int counter;
		private String name;
		private List<String> stats;

		public MyThreadFactory(String name) {
			counter = 0;
			this.name = name;
			stats = new ArrayList<>();
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r, name + "-Thread_" + counter);
			counter++;

			stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), LocalDateTime.now()));

			return t;
		}

		public String getStats() {
			StringBuffer buffer = new StringBuffer();
			for (String s : stats) {
				buffer.append(s).append("\n");
			}
			return buffer.toString();
		}
	}

}

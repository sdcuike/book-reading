package com.doctor.ch04;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Creating a thread executor
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 下午4:49:52
 */
public class CreatingAThreadExecutor {

	public static void main(String[] args) {
		Server server = new Server();
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task" + i);
			server.executeTask(task);
		}

		server.endServer();
	}

	static class Server {
		private ThreadPoolExecutor executor;

		public Server() {
			// executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
		}

		public void executeTask(Task task) {
			System.out.printf("Server: A new task has arrived \n");
			executor.execute(task);
			System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
			System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
			System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
			System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());

		}

		public void endServer() {
			executor.shutdown();
		}
	}

	static class Task implements Runnable {
		private LocalDateTime initDateTime;
		private String name;

		public Task(String name) {
			initDateTime = LocalDateTime.now();
			this.name = name;
		}

		@Override
		public void run() {
			System.out.printf("%s : Task %s: Created on: %s \n", Thread.currentThread().getName(), name, initDateTime);
			System.out.printf("%s : Task %s: Started on: %s \n", Thread.currentThread().getName(), name, LocalDateTime.now());

			try {
				long duration = (long) (Math.random() * 10);
				System.out.printf("%s : Task %s: Doing a task during %d seconds \n", Thread.currentThread().getName(), name, duration);
				TimeUnit.SECONDS.sleep(duration);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.printf("%s : Task %s: Finished on: %s \n", Thread.currentThread().getName(), name, LocalDateTime.now());
		}

	}

}

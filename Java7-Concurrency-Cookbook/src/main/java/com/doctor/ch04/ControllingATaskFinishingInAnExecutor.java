package com.doctor.ch04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Controlling a task finishing in an executor
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 下午8:37:16
 * 
 *       The FutureTask class provides a method called done() that allows you to execute some
 *       code after the finalization of a task executed in an executor. It can be used to make some
 *       post-process operations, generating a report, sending results by e-mail, or releasing some
 *       resources. This method is called internally by the FutureTask class when the execution of
 *       the task that this FutureTask object is controlling finishes. The method is called after the
 *       result of the task is set and its status is changed to the isDone status, regardless of whether
 *       the task has been canceled or finished normally.
 *       By default, this method is empty. You can override the FutureTask class and implement this
 *       method to change this behavior. In this recipe, you will learn how to override this method to
 *       execute code after the finalization of the tasks.
 */
public class ControllingATaskFinishingInAnExecutor {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		int n = 5;
		ResultTask[] resultTasks = new ResultTask[n];
		for (int i = 0; i < n; i++) {
			ExecutableTask executableTask = new ExecutableTask("Task " + i);
			resultTasks[i] = new ResultTask(executableTask);
			executorService.submit(resultTasks[i]);
		}

		TimeUnit.SECONDS.sleep(5);

		for (int i = 0; i < n; i++) {
			resultTasks[i].cancel(true);
		}

		try {
			for (int i = 0; i < n; i++) {
				if (!resultTasks[i].isCancelled()) {
					System.out.printf("%s \n", resultTasks[i].get());
				}
			}
		} catch (ExecutionException e) {

			e.printStackTrace();
		}
	}

	static class ExecutableTask implements Callable<String> {
		private String name;

		public String getName() {
			return name;
		}

		public ExecutableTask(String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			try {
				long duration = (long) (Math.random() * 10);
				System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return "hello ,word. I'm " + name;
		}
	}

	static class ResultTask extends FutureTask<String> {

		private String name;

		public ResultTask(Callable<String> callable) {
			super(callable);
			this.name = ((ExecutableTask) callable).getName();
		}

		@Override
		protected void done() {
			if (isCancelled()) {
				System.out.printf("%s: Has been canceled\n", name);
			} else {
				System.out.printf("%s: Has finished\n", name);
			}
		}

	}
}

package com.doctor.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author sdcuike
 *
 * @time 2015年10月24日 上午11:08:30
 */
public class Sec01 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// the number of available processors
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);// 4 本机CPU 4个cpu核.（top 命令，然后按 1 就可以看到)

		// Usually, a task needs to wait for the result of multiple subtasks. Instead of submitting each
		// subtask separately, you can use the invokeAll method, passing a Collection of
		// Callable instances.

		ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors + 1);
		List<Callable<Double>> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tasks.add(() -> Math.random());
		}

		List<Future<Double>> results = executorService.invokeAll(tasks);
		for (Future<Double> future : results) {
			System.err.println(future.get());
		}

		executorService.shutdown();

		// If it bothers you that the calling task blocks until all subtasks are done, you can use
		// an ExecutorCompletionService. It returns the futures in the order of
		// completion.

		ExecutorService service = Executors.newFixedThreadPool(availableProcessors + 1);
		ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(service);
		List<Callable<Integer>> taskList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int j = i;
			taskList.add(() -> j);
		}

		for (Callable<Integer> callable : taskList) {
			completionService.submit(callable);
		}

		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < taskList.size(); i++) {
			Integer integer = completionService.take().get();
			r.add(integer);
		}

		r.stream().forEachOrdered(System.out::print);
		service.shutdown();
	}
}

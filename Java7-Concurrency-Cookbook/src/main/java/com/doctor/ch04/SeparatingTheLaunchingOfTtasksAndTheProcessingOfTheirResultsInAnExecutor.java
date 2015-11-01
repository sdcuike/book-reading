package com.doctor.ch04;

/**
 * Separating the launching of tasks and the processing of their results in an executor
 * 
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 下午8:59:23
 * 
 *       Normally, when you execute concurrent tasks using an executor, you will send Runnable
 *       or Callable tasks to the executor and get Future objects to control the method. You can
 *       find situations, where you need to send the tasks to the executor in one object and process
 *       the results in another one. For such situations, the Java Concurrency API provides the
 *       CompletionService class.
 *       This CompletionService class has a method to send the tasks to an executor and a
 *       method to get the Future object for the next task that has finished its execution. Internally,
 *       it uses an Executor object to execute the tasks. This behavior has the advantage to share
 *       a CompletionService object, and sends tasks to the executor so the others can process
 *       the results. The limitation is that the second object can only get the Future objects for those
 *       tasks that have finished its execution, so these Future objects can only be used to get the
 *       results of the tasks.
 */
public class SeparatingTheLaunchingOfTtasksAndTheProcessingOfTheirResultsInAnExecutor {

	public static void main(String[] args) {

	}

}

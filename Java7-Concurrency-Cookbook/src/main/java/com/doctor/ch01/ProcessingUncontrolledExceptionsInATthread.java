package com.doctor.ch01;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.TimeUnit;

/**
 * Processing uncontrolled exceptions in a thread
 * 
 * @author sdcuike
 *
 * @time 2015年11月1日 上午9:24:34
 * 
 *       There are two kinds of exceptions in Java:
 * 
 *       Checked exceptions: These exceptions must be specified in the throws clause of a method or caught inside them. For example, IOException or ClassNotFoundException.
 * 
 *       Unchecked exceptions: These exceptions don't have to be specified or caught. For example, NumberFormatException.
 * 
 * 
 *       When a checked exception is thrown inside the run() method of a Thread object, we have
 *       to catch and treat them, because the run() method doesn't accept a throws clause. When
 *       an unchecked exception is thrown inside the run() method of a Thread object, the default
 *       behaviour is to write the stack trace in the console and exit the program.
 * 
 *       When an exception is thrown in a thread and is not caught (it has to be an unchecked
 *       exception), the JVM checks if the thread has an uncaught exception handler set by the
 *       corresponding method. If it has, the JVM invokes this method with the Thread object and
 *       Exception as arguments.
 * 
 *       If the thread has not got an uncaught exception handler, the JVM prints the stack trace in the
 *       console and exits the program.
 * 
 * 
 *       Fortunately, Java provides us with a mechanism to catch and treat the unchecked exceptions
 *       thrown in a Thread object to avoid the program ending.
 * 
 * @see UncaughtExceptionHandler
 * 
 * 
 *      The Thread class has another method related to the process of uncaught exceptions. It's the
 *      static method setDefaultUncaughtExceptionHandler() that establishes an exception
 *      handler for all the Thread objects in the application.
 *      When an uncaught exception is thrown in Thread, the JVM looks for three possible handlers
 *      for this exception.
 *      First, it looks for the uncaught exception handler of the Thread objects as we learned in this
 *      recipe. If this handler doesn't exist, then the JVM looks for the uncaught exception handler
 *      for ThreadGroup of the Thread objects as was explained in the Processing uncontrolled
 *      exceptions in a group of threads recipe. If this method doesn't exist, the JVM looks for the
 *      default uncaught exception handler as we learned in this recipe.
 *      If none of the handlers exits, the JVM writes the stack trace of the exception in the console
 *      and exits the program.
 */
public class ProcessingUncontrolledExceptionsInATthread {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Task());
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		// or
		// Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();

		TimeUnit.SECONDS.sleep(2);
		System.out.println("isAlive:" + thread.isAlive());
	}

	public static class Task implements Runnable {

		@Override
		public void run() {
			int numero = Integer.parseInt("TTT");
			System.out.println(numero);
		}

	}

	public static class ExceptionHandler implements UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.printf("An exception has been captured \n");
			System.out.printf("Thread: %s \n", t.getId());
			System.err.printf("Exception: %s: %s \n", e.getClass().getName(), e.getMessage());
			System.out.printf("Stack Trace: \n");
			e.printStackTrace(System.out);
			System.err.printf("Thread status : %s \n", t.getState());
		}

	}
}

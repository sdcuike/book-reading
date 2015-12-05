package com.doctor.ch05;

/**
 * 
 * @author sdcuike
 *
 * @time 2015年12月5日下午5:00:37
 * 
 *       Concurrency Utilities and Executors
 * 
 * 
 * 
 *       Java’s low-level thread capabilities let you create multithreaded applications that
 *       offer better performance and responsiveness over their single-threaded counterparts.
 *       However, performance issues that affect an application’s scalability and other problems
 *       resulted in Java 5’s introduction of the concurrency utilities.
 *       The concurrency utilities organize various types into three packages: java.util.
 *       concurrent, java.util.concurrent.atomic, and java.util.concurrent.locks.
 *       Basic types for executors, thread pools, concurrent hashmaps, and other high-level
 *       concurrency constructs are stored in java.util.concurrent; classes that support lockfree, thread-safe programming on single variables are stored in java.util.concurrent.
 *       atomic; and types for locking and waiting on conditions are stored in java.util.
 *       concurrent.locks.
 *       An executor decouples task submission from task-execution mechanics and
 *       is described by the Executor, ExecutorService, and ScheduledExecutorService
 *       interfaces. You obtain an executor by calling one of the utility methods in the Executors
 *       class. Executors are associated with callables and futures.
 */
public class Sec01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

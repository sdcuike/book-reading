package com.doctor.ch01;

/**
 * @author sdcuike
 *
 * @time 2015年12月3日下午10:29:30
 * 
 *       The Thread class provides an interruption mechanism in which one thread can interrupt
 *       another thread. When a thread is interrupted, it throws java.lang.InterruptedException.
 *       This mechanism consists of the following three methods:
 *       • void interrupt(): Interrupt the thread identified by the Thread
 *       object on which this method is called. When a thread is blocked
 *       because of a call to one of Thread’s sleep() or join() methods
 *       (discussed later in this chapter), the thread’s interrupted status is
 *       cleared and InterruptedException is thrown. Otherwise, the
 *       interrupted status is set and some other action is taken
 *       depending on what the thread is doing. (See the JDK
 *       documentation for the details.)
 *       • static boolean interrupted(): Test whether the current thread
 *       has been interrupted, returning true in this case. The interrupted
 *       status of the thread is cleared by this method.
 *       • boolean isInterrupted(): Test whether this thread has been
 *       interrupted, returning true in this case. The interrupted status of
 *       the thread is unaffected by this method.
 * 
 * 
 * 
 *       A thread (such as the default main thread) will occasionally start another thread to
 *       perform a lengthy calculation, download a large file, or perform some other timeconsuming activity. After finishing its other tasks, the thread that started the worker
 *       thread is ready to process the results of the worker thread and waits for the worker thread
 *       to finish and die.
 *       The Thread class provides three join() methods that allow the invoking thread to
 *       wait for the thread on whose Thread object join() is called to die:
 *       • void join(): Wait indefinitely for this thread to die.
 *       InterruptedException is thrown when any thread has
 *       interrupted the current thread. If this exception is thrown, the
 *       interrupted status is cleared.
 *       • void join(long millis): Wait at most millis milliseconds
 *       for this thread to die. Pass 0 to millis to wait indefinitely—
 *       the join() method invokes join(0). java.lang.
 *       IllegalArgumentException is thrown when millis is negative.
 *       InterruptedException is thrown when any thread has
 *       interrupted the current thread. If this exception is thrown, the
 *       interrupted status is cleared.
 *       • void join(long millis, int nanos): Wait at most millis
 *       milliseconds and nanos nanoseconds for this thread to die.
 *       IllegalArgumentException is thrown when millis is
 *       negative, nanos is negative, or nanos is greater than 999999.
 *       InterruptedException is thrown when any thread has
 *       interrupted the current thread. If this exception is thrown, the
 *       interrupted status is cleared.
 * 
 */
public class Sec02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

package com.doctor.ch01;

/**
 * 
 * @author sdcuike
 *
 * @time 2015年12月3日下午10:07:47
 * 
 *       Java applications execute via threads, which are independent paths of execution through
 *       an application’s code. When multiple threads are executing, each thread’s path can differ
 *       from other thread paths.
 * 
 *       Each Java application has a default main thread that executes the main() method. The
 *       application can also create threads to perform time-intensive tasks in the background so
 *       that it remains responsive to its users. These threads execute code sequences encapsulated
 *       in objects that are known as runnables.
 * 
 *       The Java virtual machine (JVM) gives each thread its own JVM stack to prevent
 *       threads from interfering with each other. Separate stacks let threads keep track of their next
 *       instructions to execute, which can differ from thread to thread. The stack also provides a
 *       thread with its own copy of method parameters, local variables, and return value.(线程安全）
 * 
 *       A Thread object is assigned a name, which is useful for debugging. Unless a name is
 *       explicitly specified, a default name that starts with the Thread- prefix is chosen.
 * 
 *       You can determine if a thread is alive or dead by calling Thread’s boolean isAlive()
 *       method. This method returns true when the thread is alive; otherwise, it returns false.
 * 
 *       A thread has an execution state that is identified by one of the Thread.State enum’s
 *       constants:
 *       • NEW: A thread that has not yet started is in this state.
 *       • RUNNABLE: A thread executing in the JVM is in this state.
 *       • BLOCKED: A thread that is blocked waiting for a monitor lock is in
 *       this state. (I’ll discuss monitor locks in Chapter 2.)
 *       • WAITING: A thread that is waiting indefinitely for another thread to
 *       perform a particular action is in this state.
 *       • TIMED_WAITING: A thread that is waiting for another thread to
 *       perform an action for up to a specified waiting time is in this state.
 *       • TERMINATED: A thread that has exited is in this state.
 *       Thread lets an application determine a thread’s current state by providing the
 *       Thread.State getState() method.
 * 
 *       When a computer has enough processors and/or processor cores, the computer’s
 *       operating system assigns a separate thread to each processor or core so the threads
 *       execute simultaneously. When a computer doesn’t have enough processors and/or cores,
 *       various threads must wait their turns to use the shared processors/cores.
 * 
 *       You can identify the number of processors and/or processor cores that are available
 *       to the JVM by calling the java.lang.Runtime class’s int availableProcessors() method.
 *       the return value could change during JVM execution and is never smaller than 1.
 * 
 *       Thread supports priority via its int getPriority() method, which returns the
 *       current priority, and its void setPriority(int priority) method, which sets the
 *       priority to priority. The value passed to priority ranges from Thread.MIN_PRIORITY
 *       to Thread.MAX_PRIORITY—Thread.NORMAL_PRIORITY identifies the default priority.
 * 
 *       Java lets you classify threads as daemon threads or nondaemon threads. A daemon thread
 *       is a thread that acts as a helper to a nondaemon thread and dies automatically when the
 *       application’s last nondaemon thread dies so that the application can terminate.
 *       By default, the threads associated with Thread objects are nondaemon threads. To
 *       create a daemon thread, you must call Thread’s void setDaemon(boolean isDaemon)
 *       method, passing true to isDaemon.
 * 
 *       An application will not terminate when the nondaemon default main thread
 *       terminates until all background nondaemon threads terminate. If the background threads
 *       are daemon threads, the application will terminate as soon as the default main thread
 *       terminates.
 */

public class Sec01 {

    public static void main(String[] args) {

    }

}

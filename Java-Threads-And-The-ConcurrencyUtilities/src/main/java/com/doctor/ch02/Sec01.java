package com.doctor.ch02;

/**
 * @author sdcuike
 *
 * @time 2015年12月5日上午10:14:03
 * 
 *       Developing multithreaded applications is much easier when threads don’t interact,
 *       typically via shared variables. When interaction occurs, various problems can arise that
 *       make an application thread-unsafe (incorrect in a multithreaded context).
 * 
 * 
 *       To boost performance, the compiler, the Java virtual machine (JVM), and the operating
 *       system can collaborate to cache a variable in a register or a processor-local cache, rather
 *       than rely on main memory. Each thread has its own copy of the variable. When one
 *       thread writes to this variable, it’s writing to its copy; other threads are unlikely to see the
 *       update in their copies.
 * 
 *       You can use synchronization to solve the previous thread problems. Synchronization is a
 *       JVM feature that ensures that two or more concurrent threads don’t simultaneously
 *       execute a critical section, which is a code section that must be accessed in a serial (one
 *       thread at a time) manner.
 *       This property of synchronization is known as mutual exclusion because each thread
 *       is mutually excluded from executing in a critical section when another thread is inside
 *       the critical section. For this reason, the lock that the thread acquires is often referred to as
 *       a mutex lock.
 *       Synchronization also exhibits the property of visibility in which it ensures that a
 *       thread executing in a critical section always sees the most recent changes to shared
 *       variables. It reads these variables from main memory on entry to the critical section and
 *       writes their values to main memory on exit.
 *       Synchronization is implemented in terms of monitors, which are concurrency
 *       constructs for controlling access to critical sections, which must execute indivisibly. Each
 *       Java object is associated with a monitor, which a thread can lock or unlock by acquiring
 *       and releasing the monitor’s lock (a token).
 * 
 *       Only one thread can hold a monitor’s lock. Any other thread trying to lock that
 *       monitor blocks until it can obtain the lock. When a thread exits a critical section, it
 *       unlocks the monitor by releasing the lock.
 *       Locks are designed to be reentrant to prevent deadlock (discussed later). When a
 *       thread attempts to acquire a lock that it’s already holding, the request succeeds.
 * 
 *       When synchronizing on an instance method, the lock is associated with the object
 *       on which the method is called.
 *       When synchronizing on a class method, the lock is associated with the java.lang.
 *       Class object corresponding to the class whose class method is called.
 * 
 *       Neither the Java language nor the JVM provides a way to prevent deadlock, and
 *       so the burden falls on you. the simplest way to prevent deadlock is to avoid having either a
 *       synchronized method or a synchronized block call another synchronized method/block.
 *       although this advice prevents deadlock from happening, it’s impractical because one of your
 *       synchronized methods/blocks might need to call a synchronized method in a Java api, and
 *       the advice is overkill because the synchronized method/block being called might not call any
 *       other synchronized method/block, so deadlock would not occur.
 * 
 * 
 *       You previously learned that synchronization exhibits two properties: mutual exclusion
 *       and visibility. The synchronized keyword is associated with both properties. Java also
 *       provides a weaker form of synchronization involving visibility only, and associates only
 *       this property with the volatile keyword.
 * 
 *       Because stopped has been marked volatile, each thread will access the main
 *       memory copy of this variable and not access a cached copy. The application will stop,
 *       even on a multiprocessor-based or a multicore-based machine.
 * 
 * 
 *       Use volatile only where visibility is an issue. also, you can only use this
 *       reserved word in the context of field declarations (you’ll receive an error if you try to make a
 *       local variable volatile). Finally, you can declare double and long fields volatile, but
 *       should avoid doing so on 32-bit JVMs because it takes two operations to access a double or
 *       long variable’s value, and mutual exclusion (via synchronized) is required to access their
 *       values safely.
 */
public class Sec01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

package com.doctor.ch06;

/**
 * @author sdcuike
 *
 * @time 2015年12月5日下午5:45:16
 * 
 *       Semaphores
 * 
 *       A semaphore maintains a set of permits for restricting the number of threads that can
 *       access a limited resource. A thread attempting to acquire a permit when no permits are
 *       available blocks until some other thread releases a permi.
 * 
 *       Semaphores whose current values can be incremented past 1 are known as
 *       counting semaphores, whereas semaphores whose current values can be only 0 or 1
 *       are known as binary semaphores or mutexes. in either case, the current value cannot be
 *       negative.
 * 
 *       Generally, semaphores used to control resource access should be initialized as fair,
 *       to ensure that no thread is starved out from accessing a resource. When using
 *       semaphores for other kinds of synchronization control, the throughput advantages of
 *       unfair ordering often outweigh fairness considerations.
 */
public class Sec03 {

    public static void main(String[] args) {

    }

}

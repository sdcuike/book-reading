package com.doctor.ch06;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 *
 * @time 2015年12月5日下午5:08:14
 * 
 *       Countdown Latches 测试并发是不是很有用啊
 * 
 *       A countdown latch causes one or more threads to wait at a “gate” until another thread
 *       opens this gate, at which point these other threads can continue. It consists of a count and
 *       operations for “causing a thread to wait until the count reaches zero” and “decrementing
 *       the count.”
 *       The java.util.concurrent.CountDownLatch class implements the countdown latch
 *       synchronizer. You initialize a CountDownLatch instance to a specific count by invoking
 *       this class’s CountDownLatch(int count) constructor, which throws java.lang.
 *       IllegalArgumentException when the value passed to count is negative.
 */
public class Sec01 {

    final static int threadNum = 3;

    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(threadNum);

        Runnable r = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " entered run()");
                startSignal.await();
                System.out.println(Thread.currentThread().getName() + " doing work");
                TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + "  work done");
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(20);

        for (int i = threadNum; i > 0; i--) {
            service.submit(r);
        }

        try {
            System.out.println("main thread do something");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("all starting ....");
            startSignal.countDown();

            doneSignal.await();
            System.out.println("all done");
            service.shutdown();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

package com.doctor.ch02;

/**
 * @author sdcuike
 *
 * @time 2015年10月29日 下午9:21:55
 * 
 *       1.每个计算机程序至少都有一个线程。
 *       2.每个java程序至少都有一个线程：运行应用程序本身的线程-main thread。
 *       3.在java程序中，每个程序都有一个以上的线程。比如垃圾回收与编译java 字节码成机器指令码之类的线程。
 *       4.为何写多个线程的应用程序呢，而不是写成多个应用程序：因为线程是在同一个应用程序中运行，他们共享在计算机上相同的内存
 *       空间，这样可以紧密的共享信息。
 *       5.在multitasking环境中，程序中的数据默认是分开的：每个都有自己的stack给局部变量用，且各自都有自己的对象及其他数据。
 *       6.所有的程序可以访问各种共享内存。共享内存受限于其他程序存入的数据，且访问该处的API通常与访问程序中的其他数据的API相当的不同。
 */
public class WhatIsAThread {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());// main
		System.out.println(Thread.currentThread());// Thread[main,5,main]
	}

}

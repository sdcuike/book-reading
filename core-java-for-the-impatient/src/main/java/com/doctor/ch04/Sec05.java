package com.doctor.ch04;

import java.util.ServiceLoader;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午2:20:02
 */
public class Sec05 {

	static ServiceLoader<ServiceLoaderDemo> serviceLoader = ServiceLoader.load(ServiceLoaderDemo.class);

	public static void main(String[] args) {

		for (ServiceLoaderDemo serviceLoaderDemo : serviceLoader) {
			System.out.println(serviceLoaderDemo);
			System.out.println(serviceLoaderDemo.getName());
		}
	}

}

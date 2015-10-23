package com.doctor.ch04;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午2:21:49
 */
public class ServiceLoaderDemoImpl2 implements ServiceLoaderDemo {

	@Override
	public String getName() {
		return getClass().getName();
	}

}

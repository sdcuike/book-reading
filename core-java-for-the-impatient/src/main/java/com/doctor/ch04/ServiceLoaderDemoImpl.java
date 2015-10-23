package com.doctor.ch04;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午2:21:18
 */
public class ServiceLoaderDemoImpl implements ServiceLoaderDemo {

	@Override
	public String getName() {
		return getClass().getName();
	}

}

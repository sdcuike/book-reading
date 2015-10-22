package com.doctor.ch03;

/**
 * 
 * @author sdcuike
 *
 * @time 2015年10月22日 下午3:41:50
 */
public interface Person {
	String getName();

	default int getId() {
		return 0;
	}
}

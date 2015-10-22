package com.doctor.ch03;

/**
 * 
 * @author sdcuike
 *
 * @time 2015年10月22日 下午3:42:33
 */
public interface Identified {
	default int getId() {
		return Math.abs(hashCode());
	}
}

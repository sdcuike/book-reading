package com.doctor.ch01;

import java.util.List;
import java.util.Vector;

import com.google.common.base.Preconditions;

/**
 * @author sdcuike
 *
 * @time 2015年11月3日 下午9:56:22
 */
public class Sec08 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Preconditions.checkArgument(Object.class.isAssignableFrom(String.class));
        Preconditions.checkArgument(List.class.isAssignableFrom(Vector.class));
        Preconditions.checkArgument(double.class.isAssignableFrom(double.class));

        Preconditions.checkArgument(!Object.class.isAssignableFrom(double.class));

        Preconditions.checkArgument(Class.class.isInstance(Class.class));
    }

}

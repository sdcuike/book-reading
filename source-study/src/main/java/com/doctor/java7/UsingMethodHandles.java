package com.doctor.java7;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author sdcuike
 *
 *         Created on 2016年3月19日 下午9:22:27
 */
public class UsingMethodHandles {

    public static void main(String[] args) throws Throwable {

        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(UsingMethodHandles.class, "toString", MethodType.methodType(String.class));

        UsingMethodHandles usingMethodHandles = new UsingMethodHandles();
        String string = (String) methodHandle.invokeExact(usingMethodHandles);
        System.out.println(string);
    }

    @Override
    public String toString() {

        return super.toString() + "=test";
    }
}

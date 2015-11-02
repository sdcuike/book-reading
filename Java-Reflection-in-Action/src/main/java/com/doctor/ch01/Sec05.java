package com.doctor.ch01;

import java.lang.reflect.Method;
import java.util.Vector;

/**
 * @author sdcuike
 *
 * @time 2015年11月2日 下午11:12:56
 */
public class Sec05 {

	public static void main(String[] args) throws ReflectiveOperationException {
		System.out.println(Integer.class.getName());// java.lang.Integer
		Integer[] a = new Integer[1];
		System.out.println(a.getClass().getComponentType());// class java.lang.Integer
		System.out.println(a.getClass().isArray());// true

		System.out.println(Runnable.class.isInterface());// true
		System.out.println(int.class.isPrimitive());// true

		System.out.println(Void.class);// class java.lang.Void

		Vector<Integer> vector = new Vector<>();
		vector.add(1);
		System.out.println(vector.get(0));// 1
		Method method = Vector.class.getMethod("get", new Class[] { int.class });
		Object invoke = method.invoke(vector, new Object[] { 0 });
		System.out.println(invoke);// 1

		System.out.println(Integer[].class);// class [Ljava.lang.Integer;

	}

}

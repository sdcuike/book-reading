package com.doctor.ch01;

import java.lang.reflect.Method;

/**
 * Using primitives with dynamic invocation
 * 
 * @author sdcuike
 *
 * @time 2015年11月3日 下午9:21:07
 * 
 * 
 *       with the invoke method.
 *       If the type of a parameter is a primitive, invoke expects the corresponding args
 *       array element to be a wrapper object containing the argument. For example,
 *       when invoking a method with an int parameter, wrap the int argument in a
 *       java.lang.Integer and pass it into the args array. The invoke method unwraps
 *       the argument before it passes it to the actual code for the method being invoked.
 *       The invoke method handles primitive return types by wrapping them before
 *       they are returned. Thus, when invoking a method with an int return type, the
 *       program receives an object of type Integer in return. If the method being
 *       invoked is declared with a void return, invoke returns the value null.
 *       So, primitives need to be wrapped when passed into a dynamic invocation and
 *       unwrapped when received as a return value. For clarity, consider the following
 *       dynamic call to hashCode method on our obj variable from the example.
 */
public class Sec06 {

    public static void main(String[] args) throws ReflectiveOperationException {
        Sec06 sec06 = new Sec06();
        Method method = sec06.getClass().getMethod("pow", new Class[] { int.class });
        Object invoke = method.invoke(sec06, new Object[] { 10 });
        System.out.println(invoke);
        System.out.println(invoke.getClass());
        int intValue = ((Integer) invoke).intValue();
        System.out.println(intValue);
    }

    public int pow(int i) {
        return i * i;
    }
}

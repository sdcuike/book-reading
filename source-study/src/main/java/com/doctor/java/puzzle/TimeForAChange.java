package com.doctor.java.puzzle;

import java.math.BigDecimal;

/**
 * @author sdcuike
 *
 * @time 2016年1月31日 下午9:26:52
 * 
 *       java Puzzles 之关于金钱计算那些事，java要用int、long、or BigDecimal来计算，一般我们BigDecimal。
 * 
 *       警告：用BigDecimal(String)这个构造函数，而非 BigDecimal(double)。
 * 
 * 
 *       In summary, avoid float and double where exact answers are required;
 *       for monetary calculations, use int, long, or BigDecimal。
 *       not all decimals can be represented exactly using binary floating-point.
 * 
 *       There is one caveat: Always use the BigDecimal(String) constructor,
 *       never BigDecimal(double). The latter constructor creates an instance with the
 *       exact value of its argument: new BigDecimal(.1) returns a BigDecimal representing 0.1000000000000000055511151231257827021181583404541015625.
 * 
 */
public class TimeForAChange {

    public static void main(String[] args) {
        System.out.println(2.00 - 1.10);// 0.8999999999999999

        System.out.println(2.00D - 1.10D);// 0.8999999999999999

        System.out.println(2.00F - 1.10F);// 0.9
        System.out.println(Double.toString(2.00D));// 2.0

        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.10)));// 0.9
        System.out.println(BigDecimal.valueOf(2.00F).subtract(BigDecimal.valueOf(1.10F)));// 0.899999976158142

        System.out.println(BigDecimal.valueOf(2.00D).subtract(BigDecimal.valueOf(1.10D)));// 0.9

        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));// 0.90

    }

}

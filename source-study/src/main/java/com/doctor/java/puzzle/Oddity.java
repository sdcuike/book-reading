package com.doctor.java.puzzle;

/**
 * @author sdcuike
 *
 * @time 2016年1月31日 下午9:08:54
 * 
 *       java Puzzles 之 如何正确的判断奇数
 * 
 *       如何正确的判断奇数=要考虑到正数、负数、零情况。
 */
public class Oddity {

    public static void main(String[] args) {
        System.out.println(isOddWrong(5));
        System.out.println(isOdd(5));
        System.out.println(isOddFastWay(5));
        System.out.println(isOddWrong(-5));// 这种情况下，负数就失败了
        System.out.println(isOdd(-5));
        System.out.println(isOddFastWay(-5));
        System.out.println((-5 % 2));// ，负数%得到的余数有正负号
        System.out.println((0 % 2));// ，负数%得到的余数有正负号

    }

    /**
     * 负数没考虑，负数%得到的余数有正负号
     * 
     * @param i
     * @return
     */
    private static boolean isOddWrong(int i) {
        return i % 2 == 1;
    }

    /**
     * 正确的判定奇数，数学中的非思想-非偶数就是奇数
     * 
     * @param i
     * @return
     */
    private static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    private static boolean isOddFastWay(int i) {
        return (i & 1) != 0;
    }
}

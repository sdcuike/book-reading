package com.doctor;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

/**
 * Get/Find All Months
 * 
 * @author cuikexiang
 *
 * @time 2015年11月16日 下午1:19:27
 * 
 * @see http://www.javatips.net/blog/2014/05/get-find-all-months-using-java-api
 */
public class GetOrFindAllMonths {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.ENGLISH);

        System.out.println(Arrays.toString(dateFormatSymbols.getMonths())); // [January, February, March, April, May, June, July, August, September, October, November, December, ]
        System.out.println(Arrays.toString(dateFormatSymbols.getShortMonths()));// [Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec, ]

    }

}

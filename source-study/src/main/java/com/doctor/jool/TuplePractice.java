package com.doctor.jool;

import org.jooq.lambda.tuple.Range;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;

/**
 * @author sdcuike
 *
 * @time 2015年12月31日 下午3:33:14
 */
public class TuplePractice {

    public static void main(String[] args) {
        Tuple2<Integer, Integer> tuple = Tuple.tuple(1, 2);
        System.out.println(tuple);

        int intValue = tuple.map((a, b) -> a + b).intValue();
        System.out.println(intValue);

        Range<Integer> range = Tuple.range(1, 10);
        range.list().forEach(System.out::println);

    }

}

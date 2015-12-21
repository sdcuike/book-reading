package com.doctor.ch01;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

/**
 * @author sdcuike
 *
 * @time 2015年12月21日 下午11:11:35
 */
public class Sec01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");
        Observable<String> observable = Observable.from(list);

        observable.subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("complete"));

    }

}

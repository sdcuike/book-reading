package com.doctor.RxJava.Essentials.ch02;

import java.util.concurrent.TimeUnit;

import rx.Observer;
import rx.subjects.PublishSubject;

/**
 * @author sdcuike
 *
 * @time 2016年1月24日 下午11:11:53
 */
public class PublishSubject1 {

    public static void main(String[] args) throws InterruptedException {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();

            }

            @Override
            public void onNext(String t) {
                System.out.println("onNext:" + t);

            }

        });

        publishSubject.onNext("name");
        publishSubject.onNext("dfdf");

        publishSubject.onNext("rrff");

        TimeUnit.SECONDS.sleep(20);

    }

}

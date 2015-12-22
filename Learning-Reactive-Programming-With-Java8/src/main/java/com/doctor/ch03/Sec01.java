package com.doctor.ch03;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import rx.Observable;

/**
 * @author sdcuike
 *
 * @time 2015年12月22日 上午12:12:45
 */
public class Sec01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> asList = Arrays.asList("blue", "red", "green", "yellow", "orange");

        Observable<String> observable = Observable.from(asList);
        observable.subscribe(color -> System.out.println(color + "|"), System.out::println, System.out::println);
        observable.subscribe(color -> System.out.println(color + "/"));

        Path path = Paths.get(new File("").toString(), "src", "main");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            Observable.from(directoryStream).subscribe(System.out::println);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}

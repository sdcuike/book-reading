package com.doctor.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This program crashes by throwing java.util.ConcurrentModificationException. Why? Because the
 * iterators of ArrayList are fail-fast; it fails by throwing ConcurrentModificationException if it detects that
 * the underlying container has changed when it is iterating over the elements in the container. This behavior
 * is useful in concurrent contexts when one thread modifies the underlying container when another thread is
 * iterating over the elements of the container.
 * 
 * @author sdcuike
 *
 *         Created on 2016年3月6日 上午10:24:21
 */
public class ModifyingList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("three");
        }

        // one
        // Exception in thread "main" java.util.ConcurrentModificationException
        // at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
        // at java.util.ArrayList$Itr.next(ArrayList.java:851)
        // at com.doctor.java8.ModifyingList.main(ModifyingList.java:24)

    }

}

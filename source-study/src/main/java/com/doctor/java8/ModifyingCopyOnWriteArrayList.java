package com.doctor.java8;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Modifying CopyOnWriteArrayList
 * 
 * Observe that the element “four” added three times is not printed as part of the output. This is because
 * the iterator still has access to the original (unmodified) container that had three elements. If you create a
 * new iterator and access the elements, you will find that new elements have been added to aList.
 * 
 * @author sdcuike
 *
 *         Created on 2016年3月6日 上午10:32:39
 */
public class ModifyingCopyOnWriteArrayList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("four");
        }
        // one
        // two
        // three
        System.out.println("============");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // one
        // two
        // three
        // four
        // four
        // four

    }

}

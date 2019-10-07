package com.company;

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        /*
         write your code here
         iterator and foreach
        */
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            arrayList.add(i);
        }
        long start2 = System.currentTimeMillis();
        for (int value :
                arrayList) {
            System.out.print(value);
        }
        long end2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("foreach: " + (end2 - start2));


        long start = System.currentTimeMillis();
        for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next());
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("iterator: " + (end - start));
    }
}

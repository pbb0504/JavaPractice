package com.company.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 300000; i++) {
            hashSet.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            hashSet.contains(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        // ----------------------------------------------------

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            arrayList.add("test" + i);
        }
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            arrayList.contains(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }
}

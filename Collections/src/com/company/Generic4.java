package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Generic4 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        arrayList.add("112");
        arrayList.add("113");

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);

        printColl(arrayList);
        printColl(arrayList1);
    }

    static void printColl(ArrayList<?> arrayList){
        for(Iterator<?> iterator1 = arrayList.iterator(); iterator1.hasNext();){
            System.out.println(iterator1.next());
        }
    }

    static <T> void pringColl2(ArrayList arrayList){
        for(Iterator<T> iterator = arrayList.iterator(); iterator.hasNext();){
            // 使用具体类型的好处：这里可以对具体类型进行操作
            T t = iterator.next();
            System.out.println(iterator.next());
        }
    }
}

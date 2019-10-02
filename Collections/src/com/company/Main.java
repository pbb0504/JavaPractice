package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    // 共性方法演示
    public static void main(String[] args) {
        // write your code here
        //base_method();
        //method_1();
        method_2();
    }
    private static void method_2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
//        Iterator iterator = arrayList.iterator();
//        while(iterator.hasNext()){
//            System.out.print(iterator.next()+",");
//        }
        for(Iterator it = arrayList.iterator(); it.hasNext();){
            System.out.println(it.next()+",");
        }
    }

    private static void method_1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("3");
        arrayList1.add("4");
        arrayList1.add("6");
        arrayList1.add("7");
        arrayList1.add("8");
        // 取交集
        arrayList.retainAll(arrayList1);
        System.out.println(arrayList);
    }

    private static void base_method() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        System.out.println("the column:" + arrayList);
        arrayList.remove("2");
        System.out.println("now:" + arrayList);
    }
}

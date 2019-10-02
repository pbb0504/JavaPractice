package com.company.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo {
    // list:元素有序，可以重复，因为该集合体系有索引
    // set:元素无序，不可以重复
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        System.out.println(arrayList);
        arrayList.remove(3);
        arrayList.remove("1");
        System.out.println("remove 1 and 4: "+arrayList);
        arrayList.removeIf(ele -> {
            if (ele != "5")
                return false;
            else
                return true;
        });
        System.out.println("besides 5: "+arrayList);
        arrayList.add(0,1);
        System.out.println("add a at 0: "+arrayList);
        arrayList.set(0,"after set");
        System.out.println("after set: "+arrayList);
        Object object = arrayList.get(0);
        System.out.println("get ele at 0: "+object);
        for(Iterator iterator1 = arrayList.iterator(); iterator1.hasNext();){
            System.out.print("iterator: "+iterator1.next());
        }
    }
}

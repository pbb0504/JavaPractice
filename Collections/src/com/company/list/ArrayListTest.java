package com.company.list;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        singleElements(arrayList);
    }
    private static void singleElements(ArrayList<Integer> arrayList){
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for(int i : arrayList){
            if(!arrayList1.contains(i)){
                arrayList1.add(i);
            }
        }
        System.out.println(arrayList1);
    }
}

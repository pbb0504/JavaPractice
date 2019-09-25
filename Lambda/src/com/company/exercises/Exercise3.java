package com.company.exercises;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise3 {
    public static void main(String[] args) {
        // 集合遍历
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8);
        list.forEach(System.out::print);
        list.forEach(element ->{
            if(element % 2 == 0){
                System.out.println(element);
            }
        });
    }
}

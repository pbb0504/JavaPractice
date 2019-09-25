package com.company.exercises;

import com.company.data.test.Person;

import java.util.TreeSet;

public class Exercise2 {
    public static void main(String[] args) {
        // TreeSet

        TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> o2.age - o1.age);
        treeSet.add(new Person("asd",12));
        treeSet.add(new Person("asd2",13));
        treeSet.add(new Person("asd3",14));
        treeSet.add(new Person("asd4",15));
        treeSet.add(new Person("asd5",16));
        treeSet.add(new Person("asd6",17));
        treeSet.add(new Person("asd7",18));
        treeSet.add(new Person("asd8",20));

        System.out.println(treeSet);
    }
}

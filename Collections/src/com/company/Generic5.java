package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Generic5 {
    public static void main(String[] args) {

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("1"));
        arrayList.add(new Person("2"));
        arrayList.add(new Person("3"));
        arrayList.add(new Person("4"));
        printC(arrayList);
        ArrayList<Student2> arrayList1 = new ArrayList<>();
        arrayList1.add(new Student2("1-1"));
        arrayList1.add(new Student2("1-2"));
        arrayList1.add(new Student2("1-3"));
        arrayList1.add(new Student2("1-4"));
        printC(arrayList1);

        System.out.println("---------------------------------------------");

        ArrayList<Person> arrayList2 = new ArrayList<>();
        arrayList2.add(new Person("1"));
        arrayList2.add(new Person("2"));
        arrayList2.add(new Person("3"));
        arrayList2.add(new Person("4"));
        printC2(arrayList2);
        ArrayList<Student2> arrayList3 = new ArrayList<>();
        arrayList3.add(new Student2("1-1"));
        arrayList3.add(new Student2("1-2"));
        arrayList3.add(new Student2("1-3"));
        arrayList3.add(new Student2("1-4"));
        printC2(arrayList3);
    }

    static void printC(ArrayList<? extends Person> arrayList) {
        for (Iterator<? extends Person> iterator = arrayList.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

    static void printC2(ArrayList<? super Student2> arrayList){
        for (Iterator<? super Student2> iterator = arrayList.iterator(); iterator.hasNext(); ){
            System.out.println(iterator.next());
        }
    }
}

class Person {
    private String name;
    private int age;

    Person(String name) {
        this.name = name;
    }

}

class Student2 extends Person {
    private String name;
    private int age;

    Student2(String name) {
        super(name);
    }
}

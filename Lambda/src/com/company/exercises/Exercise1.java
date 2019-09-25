package com.company.exercises;

import com.company.data.test.Person;

import java.util.ArrayList;

public class Exercise1 {
    // 集合排序
    // ArrayList<>
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("asdf",12));
        list.add(new Person("asdf2",14));
        list.add(new Person("asdf3",15));
        list.add(new Person("asdf4",11));
        list.add(new Person("asdf5",17));
        list.add(new Person("asdf6",22));
        list.add(new Person("asdf7",52));
        list.add(new Person("asdf8",19));
        list.add(new Person("asdf9",32));
        list.sort((o1, o2) -> o1.age - o2.age);
        System.out.println(list);
    }
}

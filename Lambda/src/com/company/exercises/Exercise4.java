package com.company.exercises;

import com.company.data.test.Person;

import java.util.ArrayList;
import java.util.ListIterator;


public class Exercise4 {
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
        // 删除集合中满足条件的元素
//        ListIterator<Person> iterator = list.listIterator();
//        while(iterator.hasNext()){
//            Person person = iterator.next();
//            if(person.age>20){
//                iterator.remove();
//            }
//        }

        list.removeIf(person -> person.age > 20);

        System.out.println(list);
    }
}

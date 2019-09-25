package com.company.syntax;

import com.company.data.test.Person;

public class Syntax4 {
    public static void main(String[] args) {
        PersonCreator personCreator = () -> new Person();

        // 构造方法的引用
        PersonCreator personCreator1 = Person::new;
        Person a = personCreator1.getPerson();

        PersonCreator2 personCreator2 = Person::new;
        Person b = personCreator2.getPerson("222",2);
    }
}
interface PersonCreator{
    Person getPerson();
}

interface PersonCreator2{
    Person getPerson(String name, int age);
}
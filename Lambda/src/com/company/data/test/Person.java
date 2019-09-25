package com.company.data.test;

public class Person {
    public String name;
    public int age;

    public Person() {
        System.out.println("Person类的无参构造方法执行");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person类的有参构造方法执行");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.company.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student("zhangsan", 12));
        treeSet.add(new Student("lisi", 13));
        treeSet.add(new Student("wangwu", 14));
        treeSet.add(new Student("zhaoliu", 15));
        treeSet.add(new Student("zhaoliu2", 15));

        Iterator iterator = treeSet.iterator();
        Student student;
        while (iterator.hasNext()) {
            student = (Student) iterator.next();
            System.out.println(student.getAge());
        }
    }
}

class Student implements Comparable {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student))
            throw new RuntimeException("not Student Object");
        Student s = (Student) o;
        System.out.println(((Student)o).getName() + " compare to " + this.getName());
        // 负整数，零，正整数，根据此对象是小于，等于还是大于指定对象（传进来的对象）
        // 谁大谁排后面
        if (this.age > s.age)
            return 1;
        if (this.age < s.age)
            return -1;
        return this.name.compareTo(s.name);
    }
}

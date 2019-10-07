package com.company.treeMap;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int hashCode() {
        return name.hashCode() + age * 34;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            throw new ClassCastException("类型不匹配");
        }
        Student s = (Student) obj;
        return this.name.equals(s.name) && this.age == s.age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }

    @Override
    public int compareTo(Student o) {
        int num = new Integer(this.age).compareTo(o.age);
        if (num == 0) {
            return this.name.compareTo(o.name);
        }
        return num;
    }
}
package com.company.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        map.put(new Student("gh1", 34), "上海");
        map.put(new Student("gh2", 31), "北京");
        map.put(new Student("gh3", 38), "广东");
        map.put(new Student("gh4", 36), "深圳");
        map.put(new Student("gh5", 33), "厦门");

        // keySet
        Set<Student> students = map.keySet();
        /*
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();
            System.out.println(student.getName()+"from: "+map.get(student));
        }
         */

        for (Student student :
                students) {
            System.out.println(student.getName() + "from: " + map.get(student));
        }

        // entrySet
        Set<Map.Entry<Student, String>> set = map.entrySet();
        for (Map.Entry<Student, String> en :
                set) {
            System.out.println(en.getKey().getName() + "from: " + en.getValue());
        }
    }
}

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
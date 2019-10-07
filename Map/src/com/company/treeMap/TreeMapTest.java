package com.company.treeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Student, String> treeMap = new TreeMap<>(new StudentNameComparator());
        treeMap.put(new Student("agh1", 34), "上海");
        treeMap.put(new Student("igh2", 31), "北京");
        treeMap.put(new Student("cgh3", 38), "广东");
        treeMap.put(new Student("lgh4", 36), "深圳");
        treeMap.put(new Student("gh5", 33), "厦门");

        Set<Map.Entry<Student, String>> set = treeMap.entrySet();
/*
        for (Iterator<Map.Entry<Student, String>> iterator = set.iterator(); iterator.hasNext(); ) {
            Map.Entry<Student, String> next = iterator.next();
            System.out.println(next.getKey() + "....." + next.getValue());
        }
*/
        for (Map.Entry<Student, String> entry :
                set) {
            System.out.println(entry.getKey()+"......"+entry.getValue());
        }
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2){
        int num = o1.getName().compareTo(o2.getName());
        if (num == 0){
            return new Integer(o1.getAge()).compareTo(o2.getAge());
        }
        return num;
    }
}
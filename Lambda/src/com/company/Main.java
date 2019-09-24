package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // 使用接口实现类
        Comparator comparator = new MyComparator();
        // 使用内部匿名类
        Comparator comparator1 = new Comparator() {
            @Override
            public int compare(int a, int b) {
                return a - b;
            }
        };
        // 使用lambda
        Comparator comparator2 = (a, b) -> (a - b);
    }
}

class MyComparator implements Comparator {

    @Override
    public int compare(int a, int b) {
        return a - b;
    }
}

interface Comparator {
    int compare(int a, int b);
}
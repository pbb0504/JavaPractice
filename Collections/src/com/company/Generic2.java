package com.company;

public class Generic2 {
    public static void main(String[] args) {
//        Demo<String> demo = new Demo<>();
//        demo.show("111");
//        Demo2 demo = new Demo2();
//        demo.show("1");
//        demo.show(1);
//        demo.print("1");
        Demo3<String> demo3 = new Demo3();
        demo3.show("111");
        demo3.print(111);
    }
}

class Demo<T> {
    public void show(T t) {
        System.out.println(t);
    }
}

class Demo2 {
    public <T> void show(T t) {
        System.out.println(t);
    }

    public <Q> void print(Q q) {
        System.out.println(q);
    }
}

class Demo3<T> {
    public void show(T t) {
        System.out.println(t);
    }

    public <Q> void print(Q q) {
        System.out.println(q);
    }
}
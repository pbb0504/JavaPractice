package com.company;

public class Generic3 {
    public static void main(String[] args) {
        Test3<Integer> test3 = new Test3();
        test3.show(999);
    }
}

interface Test<T>{
    void show(T t);
}

class Test2 implements Test<String>{
    public void show(String s){
        System.out.println(s);
    }
}

class Test3<T> implements Test<T>{
    public void show(T t){
        System.out.println(t);
    }
}

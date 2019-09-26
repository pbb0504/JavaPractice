package com.company.closure;

import java.util.function.Supplier;

public class ClosureDemo {
    public static void main(String[] args) {
        int n = getNumber().get();
        System.out.println(n);
    }
    private static Supplier<Integer> getNumber(){
        int num = 10;
        return () -> {
            return num;
        };
    }
}

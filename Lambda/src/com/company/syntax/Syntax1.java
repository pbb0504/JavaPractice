package com.company.syntax;

import com.company.Interfaces.*;

public class Syntax1 {
    public static void main(String[] args) {
        // 1.Lambda表达式的基础语法
        // Lambda是一个匿名函数
        // 返回值类型，参数列表，方法体
        // ():用来描述参数列表
        // {}：用来描述方法体
        // ->：Lambda运算符：读作goes to

        // 无参无返回
        LambdaNoneReturnNoneParameter lambda1 = () -> System.out.println("Hello World!");
        lambda1.test();

        // 无返回单参数
        // 实际上是实现了接口中的test()方法
        LambdaNoneReturnSingleParameter lambda2 = System.out::println;
        lambda2.test(2);

        // 无返回多参数
        LambdaNoneReturnMulticalParameter lambda3 = (int a, int b) -> System.out.println(a + b);
        lambda3.test(1, 2);

        // 单返回无参数
        LambdaSingleReturnNoneParameter lambda4 = () -> {
            System.out.println("lambda4");
            return 100;
        };
        int res = lambda4.test();
        System.out.println(res);

        // 单返回单参数
        LambdaSingleReturnSingleParameter lambda5 = (int a) -> a * 2;
        int res2 = lambda5.test(4);
        System.out.println(res2);

        // 单返回多参数
        LambdaSingleReturnMulticalParameter lambda6 = Integer::sum;
        int res3 = lambda6.test(5, 5);
        System.out.println(res3);
    }
}

package com.company.syntax;

import com.company.Interfaces.LambdaNoneReturnMulticalParameter;
import com.company.Interfaces.LambdaNoneReturnNoneParameter;
import com.company.Interfaces.LambdaNoneReturnSingleParameter;
import com.company.Interfaces.LambdaSingleReturnNoneParameter;

public class Syntax2 {
    public static void main(String[] args) {
        // 语法精简
        // 1.参数
        // 由于在接口的抽象方法中，已经定义了参数的数量和类型，所以在lambda表达式中，参数的类型可以省略
        // 如果已经省略了一个参数的类型，那么所有参数的类型都要省略
        LambdaNoneReturnMulticalParameter lambda1 = (a, b) -> System.out.println(a + b);
        // 2.参数小括号
        // 如果参数列表中参数数量只有一个，小括号可以省略
        // 这里直接输出参数
        LambdaNoneReturnSingleParameter lambda2 = System.out::println;
        // 3.方法大括号
        LambdaNoneReturnNoneParameter lambda3 = () -> System.out.println("333");
        // 4.如果方法体中唯一的一条语句是一个返回语句，则省略大括号且省略掉return
        LambdaSingleReturnNoneParameter lambda4 = () -> 10;
    }

    private static void test(int a, int b) {
        System.out.println("11111");
    }
}
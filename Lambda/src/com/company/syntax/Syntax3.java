package com.company.syntax;

import com.company.Interfaces.LambdaSingleReturnSingleParameter;

public class Syntax3 {
    public static void main(String[] args) {
        // 调用方法
        LambdaSingleReturnSingleParameter lambda1 = Syntax3::fun1;
    }
    private static int fun1(int a){
        return a * 2;
    }
}

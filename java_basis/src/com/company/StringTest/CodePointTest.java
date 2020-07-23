package com.company.StringTest;

/**
 * @author: pbb
 * @date: 2020/7/23 21:35
 */
public class CodePointTest {
    public static void main(String[] args) {
        String str = "hello";
        int n = str.length();
        int m = str.codePointCount(0,str.length());
        System.out.println(n+"....."+m);
        System.out.println("----------------------------------------");
        char a = str.charAt(0);
        char b = str.charAt(str.offsetByCodePoints(0,0));
        System.out.println(a+"....."+b);
    }
}

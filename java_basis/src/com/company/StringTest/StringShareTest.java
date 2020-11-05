package com.company.StringTest;

public class StringShareTest {
    public static void main(String[] args) {
        // 地址和内容都相等
        String a = "abc";
        String b = "abc";
        ifEquals(a,b);

        // 地址不相等 内容相等
        String c = "abc";
        String d = c + "";
        ifEquals(c,d);
    }

    static void ifEquals(String a, String b){
        if (a == b) {
            System.out.println("a == b");
        } else {
            System.out.println("a != b");
        }
        if(a.equals(b)){
            System.out.println("a.equals(b)");
        } else {
            System.out.println("!a.equals(b)");
        }
    }
}

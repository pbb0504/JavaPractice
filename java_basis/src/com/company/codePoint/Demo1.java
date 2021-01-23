package com.company.codePoint;

public class Demo1 {
    public static void main(String[] args) {
        String hello = "ab\uD835\uDD46";
        // ab𝕆
        System.out.println(hello);
        // 代码单元 辅助字符占用连续的代码单元    4
        System.out.println(hello.length());
        // 码点 在Unicode字符表中每个符号各占一个数值    3
        System.out.println(hello.codePointCount(0,hello.length()));
    }
}

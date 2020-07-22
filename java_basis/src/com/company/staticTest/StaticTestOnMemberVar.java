package com.company.staticTest;

/**
 * @author: pbb
 * @date: 2020/7/22 13:45
 */
public class StaticTestOnMemberVar {
    // 当使用private时外部类访问不到
    private static int a = 2;
    // no private
    static int b = 2;

    public static void main(String[] args) {
        System.out.println(a);

    }
}

class aaa {
    public static void main(String[] args) {
        System.out.println(StaticTestOnMemberVar.b);
    }
}

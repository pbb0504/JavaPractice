package com.company.staticTest;

/**
 * @author: pbb
 * @date: 2020/7/22 13:36
 */
public class StaticTestOnMethod {
    public static void method() {
        System.out.println("static method");
    }

    public static void main(String[] args) {
        method();
        // or
        StaticTestOnMethod.method();
        // 不允许使用类实例调用静态方法
        /*StaticTestOnMethod staticTestOnMethod = new StaticTestOnMethod();
        staticTestOnMethod.method();*/
    }
}

class Another {
    public static void main(String[] args) {
       StaticTestOnMethod.method();
    }
}

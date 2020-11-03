package com.company;

/**
 * @author 13053
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        B b;
        A a = new A();
        C c = new C();
        // c = b; 不可以  子类用父类赋值不可以
        // b = c; 可以    父类用子类赋值可以
        a.quark();
        // b.quark();
//        b.wang();  没反应
        c.wang();
        c.quark();

    }
}

class B {
    private String name;

    public void quark(){
        System.out.println("quark");
    }
}

class A extends B {
    private String AName;

    public void zhi(){
        System.out.println("zhi");
    }
}

class C extends B {
    private String CName;

    public void wang(){
        System.out.println("wang");
    }
}

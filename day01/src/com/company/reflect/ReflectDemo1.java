package com.company.reflect;

import com.company.domain.Person;

public class ReflectDemo1 {
    /**
     * 获取Class对象的方式：
     *     1. Class.forName("全类名"): 将字节码文件加载进内存，返回Class对象
     *     2.类名.class：通过类名的属性class获取
     *     3.对象.getClass():getClass()方法在Object类中定义
     */
    public static void main(String[] args) throws Exception{
        Class aClass;
        aClass = Class.forName("com.company.domain.Person");
        System.out.println(aClass);

        Class personClass = Person.class;
        System.out.println(personClass);

        Person person = new Person();
        Class personClass1 = person.getClass();
        System.out.println(personClass1);

        // 比较三个对象
        if(aClass == personClass)
            System.out.println("1方法 == 2方法");
        else
            System.out.println("1方法 != 2方法");

        if(aClass == personClass1)
            System.out.println("1方法 == 3方法");
        else
            System.out.println("1方法 != 3方法");

        if(personClass1 == personClass)
            System.out.println("3方法 == 2方法");
        else
            System.out.println("3方法 != 2方法");
    }
    static void func(int b, int... c){
        System.out.println("ddd");
    }
}

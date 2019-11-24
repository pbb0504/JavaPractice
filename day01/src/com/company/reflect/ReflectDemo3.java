package com.company.reflect;

import com.company.domain.Person;
import java.lang.reflect.Constructor;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        // 有参构造方法
        Constructor constructor;
        constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        // 创建对象
        Object instance = constructor.newInstance("张三", 30);
        System.out.println(instance);

        // 无参构造方法
//        Constructor constructor1;
//        constructor1 = personClass.getConstructor();
//        System.out.println(constructor);
        // 创建对象
        Object instance1 = personClass.newInstance();
        System.out.println(instance);
    }
}

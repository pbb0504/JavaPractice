package com.company.reflect;

import com.company.domain.Person;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        // 获取成员方法,无参
        Method method = personClass.getMethod("eat");
        Person person = new Person();
        method.invoke(person);

        // 获取成员方法，有参
        Method method1 = personClass.getMethod("eat", String.class);
        method1.invoke(person,"阿三");

        Method[] methods = personClass.getMethods();
        for (Method method2 : methods) {
            System.out.println(method2);
            String name = method2.getName();
            System.out.println(name);
        }

        // 获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}

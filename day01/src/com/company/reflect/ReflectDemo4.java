package com.company.reflect;

import com.company.domain.Person;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        // 获取成员方法
        Method method = personClass.getMethod("eat");
        Person person = new Person();
        Object invoke = method.invoke(person);
    }
}

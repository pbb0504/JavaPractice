package com.company.reflect;

import com.company.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Field a = personClass.getField("a");
        Person person = new Person();
        a.set(person,"设置a的值");
        Object var = a.get(person);
        System.out.println(var);

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Field b = personClass.getDeclaredField("b");
        // 忽略访问权限修饰符的安全检查
        b.setAccessible(true);
        b.set(person,"b值设置");
        Object value = b.get(person);
        System.out.println(value);
    }
}

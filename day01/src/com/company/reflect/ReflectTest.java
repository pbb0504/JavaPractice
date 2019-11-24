package com.company.reflect;

import com.company.domain.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Properties;

import static java.util.Objects.*;

public class ReflectTest {
    public static void main(String[] args) throws Exception{
        // 可以创建任意类的对象

        /*
        不能改变该类的任何代码
         */
        /*Person person = new Person();
        person.eat();*/


        Properties properties = new Properties();
        // 获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        // 获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 加载该类进内存
        Class<?> aClass = Class.forName(className);
        // 创建对象
        Object o = aClass.newInstance();
        // 获取方法对象
        Method method = aClass.getMethod(methodName);
        // 执行方法
        method.invoke(o);
    }
}

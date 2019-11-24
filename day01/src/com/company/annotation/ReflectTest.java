package com.company.annotation;


import java.lang.reflect.Method;

@Pro(className = "com.company.annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        // 解析注解
        // 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 获取上边的注解对象
        // 相当于在内存中执行了如下代码
        /*
        public class ProImpl implements Pro{
            public String className(){
                return "com.company.annotation.Demo1";
            }
            public String methodName(){
                return "show";
            }
        }
         */
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        // 调用注解对象中定义的抽象方法获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
//        System.out.println(className);
//        System.out.println(methodName);
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

package com.company.annotation.demo;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws Exception{
        Calculator calculator = new Calculator();
        Class<? extends Calculator> aClass = calculator.getClass();
        Method[] methods = aClass.getMethods();
        int number = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    number++;
                    bufferedWriter.write(method.getName()+"方法出异常了");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常的名称: "+e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常原因: "+e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    bufferedWriter.newLine();
                }
            }
        }
        bufferedWriter.write("本次测试一共出现"+number+"次异常");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

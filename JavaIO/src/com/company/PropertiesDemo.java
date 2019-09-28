package com.company;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        //setAndGet();
        //save();
        method_1();
    }
    // 设置和获取元素
    private static void setAndGet(){
        Properties properties = new Properties();
        properties.setProperty("zhangsan","20");
        properties.setProperty("lisi","22");
        Set<String> value = properties.stringPropertyNames();
        for(String s : value){
            System.out.println(s+properties.getProperty(s));
        }
    }
    // 将流中的数据存储到集合中
    private static void method_1(){
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader("info.txt"));
            Properties properties = new Properties();
            String val;
            while((val = bufferedReader.readLine()) != null){
                properties.setProperty(val.substring(0,val.indexOf('=')),
                        val.substring(val.indexOf('=')+1));
            }
            System.out.println(properties);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private static void save(){
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter("info.txt"));
//            StringBuilder sb = new StringBuilder();
//            sb.append("lisi:"+"20"+"\r\n")
//                    .append("zhangsan:"+"21"+"\r\n")
//                    .append("wangwu:"+"22"+"\r\n");
//            bufferedWriter.write(sb.toString());
            String s = "lisi="+"20\r\n"+"zhangsan="+"21\r\n"+"wangwu="+"22";
            bufferedWriter.write(s);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try{
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}



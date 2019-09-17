package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

    public static void main(String[] args) {
     // 创建一个字符写入流对象
        // 在bufferedWriter中有一个跨平台的换行符方法 newLine();
        /*
        FileWriter fileWriter和FileWriter fileWriter=null的区别是没有区别
        为什么有的时候需要null有的时候又不需要呢
        有null的时候相当于"有个初值"
        不至于后面返回的时候没有值
         */
        FileWriter fileWriter;
        BufferedWriter bufferedWriter=null;
        try{
            fileWriter=new FileWriter("demo2.txt");
            // 将被需要提高速度的流对象作为BufferedWriter的构造函数的参数
            bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write("bufferedWriter");
            // 缓冲区必须刷新才能写入数据
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedWriter!=null){
                try{
                    // 关闭缓冲区就是在关闭字符写入流
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
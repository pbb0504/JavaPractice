package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IOException {
	// write your code here
       // 创建一个FileWriter对象，并会在目录下创建一个demo.txt文件
        // 如果目录下已经有同名文件，则会覆盖该文件
        // 该步为创建文件写入的目的地
        FileWriter fileWriter=new FileWriter("demo.txt");
        // 写到了流中，在文件中此时没有
        fileWriter.write("test2");
        // 将缓冲区中的临时缓冲清空，放到目的地中
        //fileWriter.flush();
        // close()方法在关闭流之前，会刷新流中的数据
        // 为什么需要close，因为write的时候是在调用windows的系统资源
        fileWriter.close();
    }
}

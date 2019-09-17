package com.company;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    /*
    通过字符数组进行读取
     */
    public static void main(String[] args) {
        FileReader fileReader = null;
        int num = 0;
        // 通常定义为1024字节
        char[] chars = new char[1024];
        try {
            fileReader = new FileReader("demo.txt");
            // 返回的是个数 并把文件中的内容放进chars数组中
            num = fileReader.read(chars);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("一共" + num + "个：" + new String(chars));
    }
}
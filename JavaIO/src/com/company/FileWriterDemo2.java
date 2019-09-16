package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("demo.txt");
            fileWriter.write("IOtest");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 这里放一定要执行的操作，因为当上面try代码块中一旦出现异常就会停止操作
            // 但是close也会出现异常，所以需要进行操作
            try {
                // 一定要进行是否空的检测，因为new的时候有可能出现错误
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

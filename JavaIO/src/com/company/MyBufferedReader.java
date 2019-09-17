package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/*
装饰设计模式
对已有的对象进行功能增强
可以自定义类，通过构造方法将已有的类传入，并进行加强功能
此类称为装饰类
 */
public class MyBufferedReader {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("demo.txt");
        MyReadLine myReadLine = new MyReadLine(fileReader);
        // 原子性引用
        AtomicReference<String> s = new AtomicReference<>(myReadLine.myReadLine());
        myReadLine.myClose();
        System.out.println(s.get());
    }
}

class MyReadLine {
    private FileReader r;

    MyReadLine(FileReader r) {
        this.r = r;
    }

    String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = r.read()) != -1) {
            if (ch == '\n') {
                return sb.toString();
            } else {
                sb.append((char) ch);
            }
        }
        // 最后一行是没有回车的话，那么最后一行是不会被返回的
        // 所以这里需要再进行一次返回
        if (sb.length() != 0)
            return sb.toString();
        return null;
    }

    void myClose() {
        try {
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
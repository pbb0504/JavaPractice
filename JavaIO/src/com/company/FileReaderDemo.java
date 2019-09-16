package com.company;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        // 读文件需要先有文件
        // 创建一个文件流读取对象，并于该文件相关联
        // 同样需要关闭资源
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("demo.txt");

//            while (true) {
//                int c = fileReader.read();
//                if (c != -1)
//                    System.out.println((char)c);
//                else
//                    break;
//            }
            int c;
            while((c=fileReader.read())!=-1){
                System.out.print((char)c);
            }
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
    }
}

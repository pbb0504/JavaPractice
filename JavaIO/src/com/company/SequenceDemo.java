package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceDemo {
    public static void main(String[] args) throws IOException {
        Vector<FileInputStream> vector = new Vector<>();
        vector.add(new FileInputStream("copy_3.txt"));
        vector.add(new FileInputStream("copy_to.txt"));
        vector.add(new FileInputStream("demo.txt"));
        Enumeration<FileInputStream> enumeration = vector.elements();
        // 将多个读取流合并成一个读取流
        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        FileOutputStream fileOutputStream = new FileOutputStream("4.txt");
        int length;
        byte[] bytes = new byte[1024];
        while((length = sequenceInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,length);
        }
        fileOutputStream.close();
        sequenceInputStream.close();
    }
}

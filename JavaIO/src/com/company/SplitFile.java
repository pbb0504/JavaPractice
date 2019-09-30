package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SplitFile {
    public static void main(String[] args) throws IOException{
        splitFile();
        merge();
    }
    private static void splitFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\idealProjects\\JavaIO\\src\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!.mp3");
        FileOutputStream fileOutputStream;
        int len;
        byte[] bytes = new byte[1024*1024];
        int count = 4;
        while((len = fileInputStream.read(bytes)) != -1){
            fileOutputStream = new FileOutputStream("D:\\idealProjects\\JavaIO\\SplitFiles\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!"+(count++)+".part");
            fileOutputStream.write(bytes,0,len);
            // 为啥就分割了呢
            // 因为这里关闭流了所以上面重新生成了一个新文件来接收继续读取的流文件
            fileOutputStream.close();
        }
        fileInputStream.close();
    }
    private static void merge() throws IOException {
        Vector<FileInputStream> vector = new Vector<>();
        // 现在来看看是不是需要绝对路径
        // conclusion 不需要绝对路径
        vector.add(new FileInputStream("SplitFiles\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!4.part"));
        vector.add(new FileInputStream("SplitFiles\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!5.part"));
        vector.add(new FileInputStream("SplitFiles\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!6.part"));
        Enumeration<FileInputStream> enumeration = vector.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\idealProjects\\JavaIO\\SplitFiles\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!All.mp3");
        int len;
        byte[] bytes = new byte[1024];
        while((len = sequenceInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        sequenceInputStream.close();
    }
}

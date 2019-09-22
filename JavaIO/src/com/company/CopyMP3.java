package com.company;

import java.io.*;

public class CopyMP3 {
    public static void main(String[] args) throws IOException{
        long start = System.currentTimeMillis();
        copy_2();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    // 字节流的缓冲区 320ms
    private static void copy_1() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("D:\\idealProjects\\JavaIO\\src\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!.mp3")
        );
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("D:\\idealProjects\\JavaIO\\src\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!2.mp3")
        );
        int bytes;
        while ((bytes = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(bytes);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    // cost 21ms
    private static void copy_2() throws IOException{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("D:\\idealProjects\\JavaIO\\src\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!.mp3")
        );
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("D:\\idealProjects\\JavaIO\\src\\豊崎愛生 _ 赤崎千夏 _ 戸松遥 - 輪!Moon!dass!cry!3.mp3")
        );
        int len;
        byte[] bytes1=new byte[1024];
        while (-1 != (len = bufferedInputStream.read(bytes1))){
            bufferedOutputStream.write(bytes1,0,len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}

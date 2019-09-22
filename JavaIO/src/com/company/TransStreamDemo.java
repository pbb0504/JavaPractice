package com.company;

import java.io.*;

// 字节通向字节
public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
//        InputStream inputStream = System.in;
//        // 将字节流包装成字符流
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        // 使用缓冲区加快速度   or   为了使用readLine方法
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        OutputStream outputStream = System.out;
//        // 用OutputStreamWriter包装输出流将字符流包装成字节流
//        // 注意：需要刷新
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        // 将三句话变成一句话
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while ((line = bufferedReader1.readLine()) != null) {
            if (line.equals("over"))
                break;
            bufferedWriter1.write(line);
            bufferedWriter1.newLine();
            bufferedWriter1.flush();
        }
        bufferedReader1.close();
        bufferedWriter1.close();
    }
}

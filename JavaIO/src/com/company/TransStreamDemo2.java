package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

// 现在目的地在文件
public class TransStreamDemo2 {
    public static void main(String[] args) throws IOException {
        fileToSystem();
    }
    private static void systemToFile() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("transToFile.txt"), StandardCharsets.UTF_8));
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("over"))
                break;
            bufferedWriter.write(line);
            bufferedWriter.newLine();// 只有在缓冲流中有
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
    private static void fileToSystem() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("transToFile.txt")));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("over"))
                break;
            bufferedWriter.write(line);
            bufferedWriter.newLine();// 只有在缓冲流中有
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
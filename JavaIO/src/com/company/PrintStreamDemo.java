package com.company;

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter("demo.txt");
        String line;
        while((line = bufferedReader.readLine()) != null){
            if(line.equals("over"))
                break;
            printWriter.println(line);
        }
        printWriter.close();
        bufferedReader.close();
    }
}

package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo{
    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader("demo.txt");
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        String line;
        while ((line=lineNumberReader.readLine())!=null){
            System.out.println(lineNumberReader.getLineNumber()+": "+line);
        }
    }
}

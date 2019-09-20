package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("demo.txt");
        MyLineNumberReader myLineNumberReader = new MyLineNumberReader(fileReader);
        String column;
        while ((column = myLineNumberReader.myReadLine()) != null) {
            System.out.println(myLineNumberReader.getLineNumber() + ":" + column);
        }
        myLineNumberReader.myClose();
    }
}

class MyLineNumberReader {
    private int lineNumber;
    private Reader r;

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public MyLineNumberReader(Reader r) {
        this.r = r;
    }

    public String myReadLine() throws IOException {
        lineNumber++;
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while ((n = r.read()) != -1) {
            if (n == '\n') {
                return sb.toString();
            } else {
                sb.append((char) n);
            }
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        return null;
    }

    public void myClose() throws IOException {
        r.close();
    }
}
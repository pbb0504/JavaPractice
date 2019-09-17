package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {
    public static void main(String[] args) {
        copy_1();
    }
    private static void  copy_1(){
        FileWriter fileWriter=null;
        FileReader fileReader=null;
        int num;
        //int column;
        char[] chars=new char[1024];
        try{
            fileWriter=new FileWriter("copy_to.txt");
            fileReader=new FileReader("demo.txt");
//            while ((column=fileReader.read())!=-1){
//                fileWriter.write(column);
//            }
            while ((num=fileReader.read(chars))!=-1){
                fileWriter.write(chars,0,num);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try{
                    fileReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fileWriter!=null){
                try{
                    fileWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
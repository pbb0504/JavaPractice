package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
    public static void main(String[] args) throws IOException{
        new FileStream().readFile3();
    }
    private void writeFile(){
        FileOutputStream fos = null ;
        try{
            fos=new FileOutputStream("fos.txt");
            fos.write("666".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private void readFile(){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("fos.txt");
            int b;
            while((b=fis.read())!=-1){
                System.out.print((char)b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private void readFile2(){
        FileInputStream fis=null;
        byte[] bytes=new byte[1024];
        int len;
        try{
            fis=new FileInputStream("fos.txt");
            while((len=fis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private void readFile3() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("fos.txt");
        byte[] bytes=new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        System.out.println(new String(bytes));
        fileInputStream.close();
    }
}

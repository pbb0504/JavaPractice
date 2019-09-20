package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicCopy {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\idealProjects\\JavaIO\\src\\2.jpg");
            fileOutputStream = new FileOutputStream("D:\\idealProjects\\JavaIO\\src\\2c.jpg");
            byte[] bytes=new byte[1024];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try{
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

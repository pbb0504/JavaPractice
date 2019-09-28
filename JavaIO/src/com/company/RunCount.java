package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RunCount {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        File file = new File("setting.ini");
        if(!file.exists()){
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(file);

        properties.load(fileInputStream);
        String val = properties.getProperty("time");
        int count = 0;
        if(val != null){
            count = Integer.parseInt(val);
            if(count >= 5){
                System.out.println("您好，请充值以继续使用");
            }
        }
        count++;
        properties.setProperty("time",count+"");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream,"");
        fileOutputStream.close();
        fileInputStream.close();
    }
}













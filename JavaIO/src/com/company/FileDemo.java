package com.company;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException{
        consMethod();
    }
    private static void consMethod() throws IOException {
        File f  = new File("fileTest.txt");
        // createNewFile 如果文件已经创建就返回false，如果没创建就创建然后返回true
        // 和输出流不一样，当输出流文件已经创建时创建，会覆盖原有文件
        //sop("create:"+f.createNewFile());
        sop("delete"+f.delete());
    }
    private static void sop(Object object){
        System.out.println(object);
    }
}

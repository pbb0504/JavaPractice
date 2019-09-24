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
        sop("path:"+f.getAbsolutePath());
        // 返回绝对路径的父目录，如果是相对路径，返回null
        sop("parent:"+f.getParent());
        sop("lastModified:"+f.lastModified());
        File[] files = File.listRoots();
        for(File file : files){
            System.out.println(file);
        }
    }
    private static void sop(Object object){
        System.out.println(object);
    }
}

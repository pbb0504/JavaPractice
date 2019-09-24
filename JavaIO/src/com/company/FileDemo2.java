package com.company;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        listDemo();
        fileNameFilter();
    }
    private static void listDemo(){
        File file = new File("D:\\idealProjects\\JavaIO\\src");
        // 列出目录下所有目录和文件的名字 包含隐藏文件
        String[] strings = file.list();
        // strings may be null
        if(strings != null)
        for(String s : strings){
            System.out.println(s);
        }
    }
    private  static void fileNameFilter(){
        File dir = new File("D:\\idealProjects\\JavaIO\\src");
        String[] files = dir.list((dir1, name) -> name.endsWith(".java"));
        if(files != null)
        for(String s : files){
            System.out.println(s);
        }
    }
}

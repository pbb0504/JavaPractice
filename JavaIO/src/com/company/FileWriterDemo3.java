package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {
    /*
    数据的续写，不让新文件覆盖
     */
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("demo.txt", true);
            fileWriter.write("数据续写");
            // 数据换行      如果在记事本中打开文件，需要加上\r\n才能视为换行
            fileWriter.write("换行1\n换行2");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

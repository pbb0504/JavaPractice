package cn.pbb.mybatis.io;

import java.io.InputStream;

/**
 * @author: pbb
 * @date: 2020/6/17 22:05
 * 使用类加载器读取配置文件
 */
public class Resources {
    /**
     * 根据传入的参数获取字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}

package cn.pbb.mybatis.utils;

import cn.pbb.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: pbb
 * @date: 2020/6/18 11:23
 */
public class DataSourceUtil {
    /**
     * 用于获取连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        Connection connection;
        try{
            Class.forName(cfg.getDriver());
            connection = DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return connection;
    }
}

package cn.pbb.mybatis.sqlsession;

import cn.pbb.mybatis.cfg.Configuration;
import cn.pbb.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import cn.pbb.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author: pbb
 * @date: 2020/6/17 22:13
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}

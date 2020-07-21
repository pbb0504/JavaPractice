package cn.pbb.mybatis.sqlsession.defaults;

import cn.pbb.mybatis.cfg.Configuration;
import cn.pbb.mybatis.sqlsession.SqlSession;
import cn.pbb.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author: pbb
 * @date: 2020/6/17 22:55
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}

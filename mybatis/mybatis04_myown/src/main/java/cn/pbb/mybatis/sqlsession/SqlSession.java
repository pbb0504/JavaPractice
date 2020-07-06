package cn.pbb.mybatis.sqlsession;

import cn.pbb.dao.IUserDao;

/**
 * @author: pbb
 * @date: 2020/6/17 22:18
 * 自定义mybatis中和数据库交互的核心类
 * 可以创建dao接口的核心类
 */
public interface SqlSession {
    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}

package cn.pbb.test;

import cn.pbb.dao.IUserDao;
import cn.pbb.dao.impl.UserDaoImpl;
import cn.pbb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/6/17 16:05
 * mybatis的入门
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用工厂生产SqlSession对象
       IUserDao iUserDao = new UserDaoImpl(factory);
        // 5. 使用代理对象执行方法
        List<User> users = iUserDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }
        // 6. 释放资源
        in.close();
    }
}

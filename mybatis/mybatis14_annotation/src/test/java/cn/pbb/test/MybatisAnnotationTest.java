package cn.pbb.test;

import cn.pbb.dao.IUserDao;
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
 * @date: 2020/7/5 21:19
 */
public class MybatisAnnotationTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession(true);
        IUserDao dao = session.getMapper(IUserDao.class);
        List<User> all = dao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        session.close();
        inputStream.close();
    }
}

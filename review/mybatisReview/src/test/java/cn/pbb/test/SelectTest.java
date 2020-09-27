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
 * @date: 2020/9/27 8:54
 */
public class SelectTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = factory.openSession(true);
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = iUserDao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        inputStream.close();
    }
}

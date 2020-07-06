package cn.pbb.test;

import cn.pbb.dao.IUserDao;
import cn.pbb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/5 21:49
 */
public class AnnotationCRUDTest {
    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession(true);
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() {
        if (sqlSession != null) {
            sqlSession.close();
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void findAll() {
        List<User> all = iUserDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void findByName() {
        List<User> byName = iUserDao.findByName("%洪%");
        for (User user : byName) {
            System.out.println(user);
        }
    }

    @Test
    public void findById() {
        User byId = iUserDao.findById(21);
        System.out.println(byId);
    }
}

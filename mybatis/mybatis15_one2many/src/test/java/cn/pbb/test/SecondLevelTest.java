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

/**
 * @author: pbb
 * @date: 2020/7/6 16:33
 */
public class SecondLevelTest {
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
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById() {
        User byId = iUserDao.findById(21);
        System.out.println(byId);
        sqlSession.close();

        sqlSession=factory.openSession(true);
        IUserDao iUserDao2 = sqlSession.getMapper(IUserDao.class);
        User byId2 = iUserDao2.findById(21);
        System.out.println(byId2);
        sqlSession.close();
    }
}

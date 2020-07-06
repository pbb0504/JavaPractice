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
 * @date: 2020/7/2 21:40
 */
public class secondLevelCacheTest {
    private InputStream inputStream;
    private SqlSessionFactory factory;

    /**
     * 初始化方法
     *
     * @return IUserDao
     */
    @Before
    public void init() {
        try {
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     *
     * @throws IOException
     */
    @After
    public void destroy() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache() {
        SqlSession session1 = factory.openSession(true);
        IUserDao dao1 = session1.getMapper(IUserDao.class);
        User user = dao1.findById(21);
        System.out.println(user);
        session1.close();

        SqlSession session2 = factory.openSession(true);
        IUserDao dao2 = session2.getMapper(IUserDao.class);
        User user2 = dao2.findById(21);
        System.out.println(user2);
        session2.close();
        System.out.println(user == user2);
    }
}

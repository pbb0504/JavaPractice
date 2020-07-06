package cn.pbb.test;

import cn.pbb.dao.IUserDao;
import cn.pbb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/2 21:40
 */
public class UserTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    /**
     * 初始化方法
     *
     * @return IUserDao
     */
    @Before
    public void init() {
        try {
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession(true);
            iUserDao = sqlSession.getMapper(IUserDao.class);
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
        if (sqlSession != null) {
            sqlSession.close();
        }
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
        User user = iUserDao.findById(21);
        System.out.println(user);
        User user2 = iUserDao.findById(21);
        System.out.println(user2);
        System.out.println(user == user2);
    }

    /**
     * 测试一级缓存2
     */
    @Test
    public void testFirstLevelCache2() throws IOException {
        User user = iUserDao.findById(21);
        System.out.println(user);


        sqlSession.close();
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession(true);
        iUserDao = sqlSession.getMapper(IUserDao.class);
        User user2 = iUserDao.findById(21);
        System.out.println(user2);


        System.out.println(user == user2);
    }

    /**
     * 测试一级缓存3
     */
    @Test
    public void testFirstLevelCache3() throws IOException {
        User user = iUserDao.findById(21);
        System.out.println(user);


        sqlSession.clearCache();


        User user2 = iUserDao.findById(21);
        System.out.println(user2);


        System.out.println(user == user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache(){
        User user = iUserDao.findById(21);
        System.out.println(user);
        user.setUsername("33445666");
        user.setAddress("张家口");
        iUserDao.updateUser(user);

        User user2 = iUserDao.findById(21);
        System.out.println(user2);


        System.out.println(user == user2);
    }

}

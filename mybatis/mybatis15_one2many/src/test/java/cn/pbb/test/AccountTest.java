package cn.pbb.test;

import cn.pbb.dao.IAccountDao;
import cn.pbb.dao.IUserDao;
import cn.pbb.domain.Account;
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
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/5 21:49
 */
public class AccountTest {
    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession(true);
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> all = iAccountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

   @Test
    public void findByUid() {
       List<Account> byUid = iAccountDao.findByUid(21);
       for (Account account : byUid) {
           System.out.println(account);
       }
   }
}

package cn.pbb.test;

import cn.pbb.dao.IAccountDao;
import cn.pbb.dao.IUserDao;
import cn.pbb.domain.Account;
import cn.pbb.domain.AccountUser;
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
public class AccountTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;

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
            iAccountDao = sqlSession.getMapper(IAccountDao.class);
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
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<Account> accounts = iAccountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAllAccount() {
        List<AccountUser> accounts = iAccountDao.findAllAccount();
        for (AccountUser account : accounts) {
            System.out.println(account);
        }
    }
}

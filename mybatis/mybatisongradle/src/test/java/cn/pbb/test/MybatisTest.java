package cn.pbb.test;

import cn.pbb.dao.IAccountDao;
import cn.pbb.dao.IUserDao;
import cn.pbb.domain.Account;
import cn.pbb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MybatisTest {
    InputStream inputStream;
    SqlSession sqlSession;
    IUserDao iUserDao;
    IAccountDao iAccountDao;

    @BeforeAll
    public void init() {
        try {
            // 读取配置文件
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
            iUserDao = sqlSession.getMapper(IUserDao.class);
            iAccountDao = sqlSession.getMapper(IAccountDao.class);
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
        User byName = iUserDao.findByName("张三");
        System.out.println(byName);
    }

    @Test
    public void findAllAccount() {
        List<Account> allAccount = iAccountDao.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @AfterAll
    public void finish() {
        try {
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

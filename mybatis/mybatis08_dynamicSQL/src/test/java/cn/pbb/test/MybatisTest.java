package cn.pbb.test;

import cn.pbb.dao.IUserDao;
import cn.pbb.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/6/24 13:10
 * 测试mybatis的crud操作
 */
public class MybatisTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
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
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
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
        // 提交事务
        //sqlSession.commit();
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
        List<User> all = iUserDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 测试通过id查找用户
     */
    @Test
    public void testFindById() {
        User user = iUserDao.findById(55);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> list = iUserDao.findByName("%张伟%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("666");
        vo.setUser(user);
        List<User> list = iUserDao.findUserByVo(vo);
        for (User u : list) {
            System.out.println(u);
        }
    }

    /**
     * 根据姓名查询
     */
    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setUsername("张三");
        List<User> list = iUserDao.findUserByCondition(u);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 根据地址查询
     */
    @Test
    public void testFindByCondition2() {
        User u = new User();
        u.setAddress("北京");
        List<User> list = iUserDao.findUserByCondition(u);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 根据性别查询
     */
    @Test
    public void testFindByCondition3() {
        User u = new User();
        u.setSex("男");
        List<User> list = iUserDao.findUserByCondition(u);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 根据id集合查询用户
     */
    @Test
    public void testFindByIdList() {
        QueryVo vo = new QueryVo();
        List<Integer> idList = new ArrayList<>();
        idList.add(21);
        idList.add(32);
        idList.add(41);
        vo.setIdList(idList);
        List<User> list = iUserDao.findUserByIdList(vo);
        for (User user : list) {
            System.out.println(user);
        }
    }

}

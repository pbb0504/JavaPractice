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
     * 测试保存操作
     *
     * @throws IOException
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("里斯");
        user.setAddress("北京");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println("保存之前" + user);
        iUserDao.saveUser(user);
        System.out.println("保存之后" + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(58);
        user.setUsername("sss");
        iUserDao.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser() {
        iUserDao.deleteUser(58);
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
     * 测试查询记录总数
     */
    @Test
    public void testFindTotal() {
        int total = iUserDao.findTotal();
        System.out.println(total);
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

}

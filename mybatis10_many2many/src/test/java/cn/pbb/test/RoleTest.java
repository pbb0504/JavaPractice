package cn.pbb.test;

import cn.pbb.dao.IRoleDao;
import cn.pbb.dao.IUserDao;
import cn.pbb.domain.Role;
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
public class RoleTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IRoleDao iRoleDao;

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
            iRoleDao = sqlSession.getMapper(IRoleDao.class);
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
     * 每个角色的信息
     */
    @Test
    public void testFindAll() {
        List<Role> roles = iRoleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}

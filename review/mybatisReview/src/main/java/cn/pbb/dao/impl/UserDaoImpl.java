package cn.pbb.dao.impl;

import cn.pbb.dao.IUserDao;
import cn.pbb.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/9/28 11:26
 */
public class UserDaoImpl implements IUserDao {
    SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public List<User> getUsers() {
        SqlSession sqlSession = factory.openSession(true);
        List<User> users = sqlSession.selectList("cn.pbb.dao.IUserDao.getUsers");
        sqlSession.close();
        return users;
    }
}

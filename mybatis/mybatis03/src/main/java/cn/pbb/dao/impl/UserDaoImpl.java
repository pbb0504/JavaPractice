package cn.pbb.dao.impl;

import cn.pbb.dao.IUserDao;
import cn.pbb.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/6/17 16:57
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("cn.pbb.dao.IUserDao.findAll");
        session.close();
        return users;
    }
}

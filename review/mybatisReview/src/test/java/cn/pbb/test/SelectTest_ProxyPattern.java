package cn.pbb.test;

import cn.pbb.dao.IUserDao;
import cn.pbb.dao.impl.UserDaoImpl;
import cn.pbb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/9/27 8:54
 */
public class SelectTest_ProxyPattern {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        IUserDao iUserdao = new UserDaoImpl(factory);
        List<User> users = iUserdao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        inputStream.close();
    }
}

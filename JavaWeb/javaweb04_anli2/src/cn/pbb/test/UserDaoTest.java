package cn.pbb.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import cn.pbb.dao.UserDao;
import cn.pbb.domain.User;
import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;

/**
 * @author: pbb
 * @date: 2020/7/30 15:56
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("marsbaby");
        user.setPassword("123");
        User user1 = dao.login(user);
        System.out.println(user1);
    }
}

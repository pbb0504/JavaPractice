package cn.pbb.dao;

import cn.pbb.domain.User;
import cn.pbb.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/30 15:43
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * login
     * @param user username and passwrod
     * @return user
     */
    public User login(User user){
        try{
            String sql = "select * from user2 where username = ? and password = ?";
            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
            return users.get(0);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

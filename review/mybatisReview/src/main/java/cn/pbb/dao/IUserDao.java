package cn.pbb.dao;

import cn.pbb.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 13053
 */
public interface IUserDao {
    /**
     * get all users
     * @return list of users
     */
    @Select("select * from employee")
    public List<User> getUsers();
}

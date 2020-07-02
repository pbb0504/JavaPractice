package cn.pbb.dao;

import cn.pbb.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 13053
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}

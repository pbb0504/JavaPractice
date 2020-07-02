package cn.pbb.dao;

import cn.pbb.domain.User;

import java.util.List;

/**
 * @author 13053
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有数据
     * @return list<user>
     */
    List<User> findAll();

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    User findById(Integer userId);


}

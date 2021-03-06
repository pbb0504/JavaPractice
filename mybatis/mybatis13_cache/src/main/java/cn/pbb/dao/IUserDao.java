package cn.pbb.dao;

import cn.pbb.domain.User;

import java.util.List;

/**
 * @author 13053
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有数据,同时获取到用户下所有账户信息
     * @return list<user>
     */
    List<User> findAll();

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

}

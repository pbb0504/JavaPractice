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
     * 保存用户
     * @param user
     * @return
     */
    void saveUser(User user);

    /**
     * 更改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return number
     */
    int findTotal();

    /**
     * 根据QueryVo查询用户
     * @param vo
     * @return
     */
//    List<User> findUserByVo(QueryVo vo);
}

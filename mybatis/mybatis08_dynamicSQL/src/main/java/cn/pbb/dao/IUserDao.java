package cn.pbb.dao;

import cn.pbb.domain.QueryVo;
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

    /**
     * 根据用户名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据QueryVo查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数进行查询
     * @param user 查询的条件，有可能有姓名、地址、性别等
     * @return List<User>
     */
    List<User> findUserByCondition(User user);

    /**
     * 查找指定id的用户们
     * @param vo
     * @return
     */
    List<User> findUserByIdList(QueryVo vo);
}

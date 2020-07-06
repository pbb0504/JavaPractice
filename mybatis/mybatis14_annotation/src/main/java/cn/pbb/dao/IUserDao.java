package cn.pbb.dao;

import cn.pbb.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 13053
 * 在mybatis中针对CRUD一共由四个注解
 * @Select @Update @Delete @Insert
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user;")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday});")
    void saveUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id};")
    void deleteUser(Integer id);

    /**
     * 改变用户信息
     * @param user
     */
    @Update("update user set username=#{username} where id=#{id};")
    void updateUser(User user);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username};")
    List<User> findByName(String name);

    /**
     * 查数量
     * @return
     */
    @Select("select count(*) from user;")
    int findTotal();
}

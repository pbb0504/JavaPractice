package cn.pbb.dao;

import cn.pbb.domain.User;
import lombok.ToString;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 13053
 * 在mybatis中针对CRUD一共由四个注解
 * @Select @Update @Delete @Insert
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user;")
    @Results(id="userMap",value = {
            @Result(id=true,column="id",property = "userId"),
            @Result(column="username",property = "userName"),
            @Result(column="address",property = "userAddress"),
            @Result(column="sex",property = "userSex"),
            @Result(column="birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select="cn.pbb.dao.IAccountDao.findByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username};")
    @ResultMap("userMap")
    List<User> findByName(String name);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id};")
    @ResultMap("userMap")
    User findById(Integer id);

}

package cn.pbb.dao;

import cn.pbb.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    User findByName(String username);
}

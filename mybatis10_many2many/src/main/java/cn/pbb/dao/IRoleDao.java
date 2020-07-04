package cn.pbb.dao;

import cn.pbb.domain.Role;

import java.util.List;

/**
 * @author 13053
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}

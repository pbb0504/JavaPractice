package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/3 15:37
 */
@Data
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    // 多对多的关系映射，一个角色可以属于多个用户
    private List<User> users;
}

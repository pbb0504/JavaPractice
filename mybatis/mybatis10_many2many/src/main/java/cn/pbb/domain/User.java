package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/6/18 16:24
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;

    // 一对多映射：主表实体应该包括从表实体的集合引用
    private List<Role> roles;
}

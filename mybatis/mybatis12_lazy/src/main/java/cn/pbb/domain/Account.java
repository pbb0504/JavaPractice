package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: pbb
 * @date: 2020/7/2 21:28
 */
@Data
public class Account implements Serializable {
    // 从表实体应该包含一个主表实体的对象引用
    private Integer id;
    private Integer uid;
    private Integer money;
    private User user;
}

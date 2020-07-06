package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: pbb
 * @date: 2020/7/6 13:48
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    // 多对一，mybatis中成为一对一
    private User user;
}

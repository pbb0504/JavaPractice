package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: pbb
 * @date: 2020/7/2 21:28
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer money;
}

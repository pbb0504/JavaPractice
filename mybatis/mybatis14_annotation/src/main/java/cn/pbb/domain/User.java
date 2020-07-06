package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: pbb
 * @date: 2020/7/5 20:58
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
}

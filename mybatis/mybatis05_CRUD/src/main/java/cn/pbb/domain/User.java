package cn.pbb.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

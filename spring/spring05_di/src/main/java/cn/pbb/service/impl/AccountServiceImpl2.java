package cn.pbb.service.impl;

import cn.pbb.service.IAccountService;

import java.util.Date;

/**
 * @author: pbb
 * @date: 2020/7/6 21:25
 * 业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount执行了"+name+age+birthday);
    }
}

package cn.pbb.service.impl;

import cn.pbb.service.IAccountService;

import java.util.Date;

/**
 * @author: pbb
 * @date: 2020/7/6 21:25
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    AccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount执行了"+name+age+birthday);
    }
}

package cn.pbb.jdbctemplate;

import cn.pbb.dao.IAccountDao;
import cn.pbb.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: pbb
 * @date: 2020/7/18 20:36
 * jdbctemplate的最基本用法
 */
public class JdbcTemplateDemo04 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
    }
}

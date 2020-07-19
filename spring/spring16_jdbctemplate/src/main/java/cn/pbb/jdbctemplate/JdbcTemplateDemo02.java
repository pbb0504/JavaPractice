package cn.pbb.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: pbb
 * @date: 2020/7/18 20:36
 * jdbctemplate的最基本用法
 */
public class JdbcTemplateDemo02 {
    private DriverManagerDataSource dataSource;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        template.execute("update account2 set money = 1000 where id = 3");
    }
}

package cn.pbb.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: pbb
 * @date: 2020/7/18 20:36
 * jdbctemplate的最基本用法
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///db1");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql0504");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.execute("insert into account2(name,money) values('aaa',1000)");
    }
}

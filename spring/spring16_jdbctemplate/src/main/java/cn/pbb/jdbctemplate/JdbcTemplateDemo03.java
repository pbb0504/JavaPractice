package cn.pbb.jdbctemplate;

import cn.pbb.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/18 20:36
 * jdbctemplate的最基本用法
 */
public class JdbcTemplateDemo03 {
    private DriverManagerDataSource dataSource;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // save
        //template.update("insert into account2(name,money)values(?,?)","555",3000f);
        // update
        //template.update("update account2 set name = ?,money = ? where id = ?","aaa",6000f,1);
        // delete
        //template.update("delete from account2 where id = ?",6);
        // findAll

//        List<Account> accounts = template.query("select * from account2", new AccountRowMapper());
        /*List<Account> accounts = template.query("select * from account2", new BeanPropertyRowMapper<Account>(Account.class));

        for (Account account : accounts) {
            System.out.println(account);
        }*/
        // findOne
        /*List<Account> accounts = template.query("select * from account2 where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        for (Account account : accounts) {
            System.out.println(account);
        }*/

        // 查询返回一行一列（使用聚合函数，但不加group by子句）
        Integer object = template.queryForObject("select count(*) from account2 where money > ?", Integer.class, 1000);
        System.out.println(object);

    }
}

class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt(i));
        account.setMoney(resultSet.getFloat(i));
        account.setName(resultSet.getString(i));
        return account;
    }
}
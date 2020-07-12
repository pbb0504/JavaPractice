package cn.pbb.test;

import cn.pbb.domain.Account;
import cn.pbb.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 12:22
 * 导入spring整合junit的jar包
 * 使用junit提供的注解把原有的main方法换成spring的main方法Runwith
 * 告知spring，xml还是注解，说明位置
 *   ContextConfiguration
 *      location:指定xml 加上classpath
 *      classes：指定注解类
 *
 *  当我们使用spring5版本时，要求junit版本必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(2000f);
        account.setName("999");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setName("333");
        account.setMoney(6000f);
        account.setId(1);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(4);
    }
}

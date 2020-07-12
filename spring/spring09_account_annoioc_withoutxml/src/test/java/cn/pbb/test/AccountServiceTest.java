package cn.pbb.test;

import cn.pbb.domain.Account;
import cn.pbb.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 12:22
 */
public class AccountServiceTest {


    private ApplicationContext ac;
    private IAccountService as;

    @Before
    public void init(){
//        ac = new ClassPathXmlApplicationContext("bean.xml");
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        as = ac.getBean("accountService",IAccountService.class);
    }

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

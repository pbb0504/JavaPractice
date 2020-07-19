package cn.pbb.test;

import cn.pbb.domain.Account;
import cn.pbb.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 12:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","ccc",200f);
    }

    /*@Test
    public void testFindAll(){
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }*/
}

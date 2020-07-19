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
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 12:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private static IAccountService as;

    public static void main(String[] args) {

        as.transfer("ccc","333",200f);
        
    }
}

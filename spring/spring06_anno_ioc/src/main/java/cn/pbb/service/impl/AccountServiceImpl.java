package cn.pbb.service.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: pbb
 * @date: 2020/7/6 21:25
 * 业务层实现类
 * <bean id="accountService" class="cn.pbb.service.impl.AccountServiceImpl"
 * scope="" init-method="" destroy-method=""
 * <property name value ref></property>
 * />
 * 用于创建对象的注解
 *      他们的作用和在XML配置文件中编写一个《bean》标签实现的共能是一样的
 * @Component
 *  用于把当前类对象存入spring容器中
 *  属性：value 用于指定id，当忽略时默认值是当前类名且首字母小写
 * @Controller：一般用在表现层
 * @Service：业务层
 * @Repository：持久层
 * 以上三个注解，他们的作用和属性与Component的相同，
 * 他们三个是spring框架为我们提供明确的三层使用，是我们的三层对象更加清晰
 *
 * 用于注入数据的
 *      和在xml配置文件中的bean标签中写一个property标签的作用是一样的
 *      Autowired:
 *          自动按照类型注入，只要容器中有一个唯一的bean对象类型和要注入的变量类型匹配，就可以注入成功
 *          如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *          如果ioc容器中有多个容器匹配时
 *          出现位置：变量、方法
 *          细节：使用注解注入时，set方法不是必须的
 *
 *      Qualifier：
 *          作用：在按照类型注入的基础之上，再按照名称注入，在给类成员注入时，不能单独使用，再给方法参数注入时可以
 *          属性：用于指定注入bean的id
 *      Resource:
 *          直接按照bean的id使用，但是属性不是value而是name
 *
 *      以上三个注解都只能注入其他bean类型的数据，基本类型和String类型无法使用上述注解实现
 *      集合类型的注入之恩呢通过xml来实现
 *
 * @Value注解
 *      作用：用于注入基本类型和String类型
 *      属性：value（用于指定数据的值）可以使用spring中的SpEL（spring的el表达式）
 *          SpEL写法：${表达式}
 * 用于改变作用范围的
 *      在bean标签中使用scope是一样的
 *      Scope：
 *          作用：用于指定bean的作用范围
 *          属性：value（指定范围的取值）singleton prototype
 * 和生命周期相关的:了解
 *      在bean标签中使用init-method和destroy-method作用是一样的
 *      PreDestroy
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */
@Service("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
    /*@Autowired
            @Qualifier("accountDao")*/
    @Resource(name = "accountDao")
    IAccountDao iAccountDao;
    @Override
    public void saveAccount() {
        iAccountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}

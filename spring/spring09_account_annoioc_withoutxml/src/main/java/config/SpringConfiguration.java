package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author: pbb
 * @date: 2020/7/12 12:52
 * Configuration
 * 作用：指定当前类是一个配置类
 * ComponentScan
 * 作用：通过注解指定spring在创建容器时要扫描的包
 * 细节：当配置类作为annotationConfigApplicationContext对象创建的参数时，该注解可以不写
 * 属性：value和basePackage的作用是一样的，都是用于指定创建容器时要扫描的包
 *  我们使用此注解就等同于在xml中配置了<context:component-scan base-package="cn.pbb"/>
 *
 *  Bean
 *  作用：把当前方法的返回值作为bean对象放入ioc容器
 *  属性：
 *      name：用于指定bean的id，默认值是：当前方法的名称
 *      如果方法有参数，那么spring框架会从容器中查找有没有可用的bean，
 *      查找的方式同autowired，自动按照类型注入
 *
 *  Import
 *      作用：用于导入其他的配置类
 *      属性：value（用于其他配置类的指定）当我们使用Import注解后，用import注解的类，就是主配置类，而导入的都是子配置类
 *
 *
 *  PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：类路径下的文件名称  classpath:name
 */
//@ComponentScan({"cn.pbb","config"})
@ComponentScan("cn.pbb")
//@Configuration
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}

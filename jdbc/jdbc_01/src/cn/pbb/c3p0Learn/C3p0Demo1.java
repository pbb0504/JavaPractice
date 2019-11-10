package cn.pbb.c3p0Learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
* c3p0的演示
* */
public class C3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        // 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 获取连接对象
        Connection connection = ds.getConnection();
        // 打印
        System.out.println(connection);
    }
}

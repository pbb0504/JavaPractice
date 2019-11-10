package cn.pbb.c3p0Learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 获取连接池
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 10; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i+": "+connection);
        }
    }
}

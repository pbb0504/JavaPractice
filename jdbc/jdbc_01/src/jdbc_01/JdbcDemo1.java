package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiibaidb",
                "root", "MySQL0504");
        // 4.定义sql语句
        String sql = "select lastName,firstName " +
                "from employees " +
                "where officeCode = 1";
        //5. 获取执行sql的对象
        Statement statement = connection.createStatement();
        // 6.执行sql
        ResultSet s = statement.executeQuery(sql);
        // 7.处理结果
        String lastName, firstName;
        System.out.println("lastName\tfirstName\r");
        while (s.next()) {
            lastName = s.getString("lastName");
            firstName = s.getString("firstName");
            System.out.println(lastName + "\t" + firstName + "\t");
        }
        // 8.关闭资源
        statement.close();
        connection.close();
    }
}

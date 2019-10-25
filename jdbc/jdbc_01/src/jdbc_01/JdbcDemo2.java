package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args) throws Exception{
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3.获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise",
                "root","MySQL0504");
        // 4.sql语句
        String sql = "select * from persons";
        // 5.获取执行sql的对象
        Statement statement = connection.createStatement();
        // 6.执行sql语句
        ResultSet s = statement.executeQuery(sql);
        // 7.处理结果集
        String name;
        int age;
        System.out.println("name\tage\t");
        while(s.next()){
            name = s.getString("name");
            age = s.getInt("age");
            System.out.println(name+"\t"+age+"\t");
        }
        // 8.关闭资源
        statement.close();
        connection.close();
    }
}

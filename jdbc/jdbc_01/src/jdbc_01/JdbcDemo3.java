package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo3 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise",
                "root","MySQL0504");
        String sql = "insert into persons values('wangwu',10)";
        String sqlAfterInsert = "select * from persons";
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        ResultSet resultSet= statement.executeQuery(sqlAfterInsert);
        System.out.println(count);
        String name;
        int age;
        System.out.println("name\tage\t");
        while (resultSet.next()){
            name = resultSet.getString("name");
            age = resultSet.getInt("age");
            System.out.println(name+"\t"+age+"\t");
        }
        statement.close();
        connection.close();
    }
}

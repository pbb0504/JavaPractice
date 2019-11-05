package jdbc_01;

import util.JdbcUtils;
import java.sql.*;

public class JdbcUtilsTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtils.getConnection();
            String sqlAfterInsert = "select * from persons";
            statement = connection.createStatement();
            resultSet= statement.executeQuery(sqlAfterInsert);
            String name;
            int age;
            System.out.println("name\tage\t");
            while (resultSet.next()){
                name = resultSet.getString("name");
                age = resultSet.getInt("age");
                System.out.println(name+"\t"+age+"\t");
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
           JdbcUtils.close(resultSet,statement,connection);
        }
    }
}

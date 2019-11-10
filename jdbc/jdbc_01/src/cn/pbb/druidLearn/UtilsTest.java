package cn.pbb.druidLearn;

import util.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilsTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "select * from account";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            String name = "";
            double salary = 0.00;
            while(resultSet.next()){
                name = resultSet.getString("name");
                salary = resultSet.getDouble("salary");
                System.out.println(name + ": " +salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(resultSet,statement,connection);
        }
    }
}

package jdbc_01;

import util.JdbcUtils;
import java.sql.*;
public class Shiwuguanli {
    public static void main(String[] args) {
        // 获取链接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try{
            connection = JdbcUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            String sql = "update account set salary = salary - ? where name = ?";
            String sql2 = "update account set salary = salary + ? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement.setDouble(1,500);
            preparedStatement.setString(2,"zhangsan");

            preparedStatement1.setDouble(1,500);
            preparedStatement1.setString(2,"lisi");

            preparedStatement.executeUpdate();
            // 制造异常：这时后面的sql不会执行
            int a = 3/0;
            preparedStatement1.executeUpdate();
            // 提交事务
            connection.commit();
        }catch (SQLException e){
            // 事务回滚
            try {
                if(connection != null)
                    connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(preparedStatement,connection);
            JdbcUtils.close(preparedStatement1,null);
        }
    }
}

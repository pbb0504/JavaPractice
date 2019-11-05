package jdbc_01;

import util.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

public class PracticeLogIn {
    public static void main(String[] args) {
        System.out.println("请输入用户名");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        Scanner scanner1 = new Scanner(System.in);
        String password = scanner1.nextLine();
        boolean flag = new LogIn2().in(username,password);
        if(flag == true){
            System.out.println("登陆成功");
        }else
            System.out.println("登录失败");
    }
}

class LogIn{
    boolean in(String username, String password){
        if(username == null || password == null)
            return false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "select * from user where username = '"+username+"'and password = '"+password+"'";
            statement = connection.createStatement();
             resultSet = statement.executeQuery(sql);
            return resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(statement,connection);
        }
        return false;
    }
}

class LogIn2{
    boolean in(String username, String password){
        if(username == null || password == null)
            return false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,preparedStatement,connection);
        }
        return false;
    }
}
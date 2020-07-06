package cn.pbb.jdbc;

import java.sql.*;

/**
 * @author: pbb
 * @date: 2020/7/6 20:44
 * 程序的耦合
 *  耦合：程序间的依赖关系
 *      包括：
 *          类之间的依赖
 *          方法间的依赖
 *  解耦：降低程序间的依赖关系
 *  实际开发中应该做到：
 *      编译期不依赖，运行时才依赖。
 *  解耦的思路：
 *      1. 创建对象的时候，使用反射来创建对象，而避免使用new关键字
 *      2. 通过读取配置文件来获取要创建的对象全限定类名
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        // 注册驱动 获取连接 获取操作数据库的预处理对象 执行sql，得到结果集 遍历结果集 释放资源
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","mysql0504");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account2;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}

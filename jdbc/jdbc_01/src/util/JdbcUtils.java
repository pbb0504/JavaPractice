package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    // 为什么是静态的变量：只有静态的变量才能被静态代码块访问
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /*
    文件的读取：只需要读取一次即可。使用静态代码块
     */
    static{
        // 读取资源文件，获取值
        try {
            //1. Properties集合类
            Properties pro = new Properties();
            // 获取src路径下的文件->Classloader 类加载器
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            assert resource != null;
            String path = resource.getPath();
            //2. 加载文件
            pro.load(new FileReader(path));

            //3.获取属性
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection){
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet,Statement statement, Connection connection){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

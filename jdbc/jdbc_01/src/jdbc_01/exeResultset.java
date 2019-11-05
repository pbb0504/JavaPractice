package jdbc_01;

import java.sql.*;

public class exeResultset {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise",
                    "root","MySQL0504");
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
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

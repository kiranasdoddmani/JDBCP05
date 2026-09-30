package org.example.config;

import java.sql.*;

public class ReadExample {

    private static String url = "jdbc:mysql://localhost:3306/college";
    private static String username="root";
    private static String password=".............";

    public static void main(String[] args) {

        String sql="SELECT * FROM Students";
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement= connection.createStatement();
             ResultSet resultSet=statement.executeQuery(sql);

             while(resultSet.next()){
                 int id=resultSet.getInt("id");
                 String name=resultSet.getString("name");
                 int age=resultSet.getInt("age");
                 String course=resultSet.getString("course");
                 int marks=resultSet.getInt("marks");

                 System.out.println((id+" | "+name+" | "+age+" | "+course+" | "+marks));
             }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

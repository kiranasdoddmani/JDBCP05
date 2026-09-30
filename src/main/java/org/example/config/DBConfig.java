package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {
    private static String url = "jdbc:mysql://localhost:3306/college";
    private static String username="root";
    private static String password="...........";

     public static Statement getInstance(){
         try {
             Connection connection= DriverManager.getConnection(url,username,password);
             Statement statement=connection.createStatement();
             return statement;
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
}

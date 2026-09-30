package org.example;

import org.example.config.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AppTest {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Id:");
         int id=sc.nextInt();
         sc.nextLine();

         System.out.println("Enter Name:");
         String name=sc.nextLine();

         System.out.println("Enter Your age:");
         int age=sc.nextInt();
        sc.nextLine();

         System.out.println("Course Name:");
         String course=sc.nextLine();

         System.out.println("Enter Marks:");
         int marks=sc.nextInt();

        String sql="INSERT INTO Students (id,name,age,course,marks) VALUES (?,?,?,?,?)";

        System.out.println((id+" "+name+" "+age+" "+course+" "+marks));
        System.out.println(sql);

        try {
            Connection connection= DBConfig.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,course);
            preparedStatement.setDouble(5,marks);

            int row= preparedStatement.executeUpdate();
            System.out.println(row +" Row Inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

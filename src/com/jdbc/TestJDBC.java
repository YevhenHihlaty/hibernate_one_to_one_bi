package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try{
            System.out.println("Connecting to database : " + jdbcURL);
            Connection connection =
                    DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Connection successful!!!!!");

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }
}

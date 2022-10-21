package com.studentTest.util;

import java.sql.*;

public class JDBCHelper {
    public static Connection JDBCConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection jdbcConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            return  jdbcConnection;
        }catch (Exception e){

        }
        return null;
    }


}

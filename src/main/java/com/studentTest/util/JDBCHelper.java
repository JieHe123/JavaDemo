package com.studentTest.util;

import java.sql.*;

public class JDBCHelper {
    public static Connection JDBCConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection jdbcConnection= DriverManager.getConnection("jdbc:mysql://database-1.cmwp50a1bvgd.us-east-1.rds.amazonaws.com:3306/student", "root", "root1234");
            return  jdbcConnection;
        }catch (Exception e){

        }
        return null;
    }


}

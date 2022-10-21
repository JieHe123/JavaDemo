package com.studentTest.util;

import com.studentTest.dao.loginDaoImpl;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        new loginDaoImpl().updatePwd();
    }
}


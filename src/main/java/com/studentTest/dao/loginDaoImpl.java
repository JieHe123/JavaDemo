package com.studentTest.dao;

import com.studentTest.bean.User;
import com.studentTest.util.JDBCHelper;

import javax.management.Query;
import java.rmi.server.ExportException;
import java.sql.*;


public class loginDaoImpl implements loginDao {
    @Override
    public User loginDao(User user_createBy_service) {
        User user_creatByDao = new User();

        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
            String sql = "select * from user where u_id=" + user_createBy_service.getU_id();
            PreparedStatement crunchifyPrepareStat = jdbcConnection.prepareStatement(sql);
            //crunchifyPrepareStat.setString(1, "");
            ResultSet rs = crunchifyPrepareStat.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt("u_id");
                user_creatByDao.setU_id(uid);
                String name = rs.getString("u_name");
                user_creatByDao.setU_name(name);
                String pwd = rs.getString("u_pwd");
                user_creatByDao.setU_pwd(pwd);
                String phone = rs.getString("u_phone");
                user_creatByDao.setU_phone(phone);
            }
        } catch (Exception e) {
        }

        return user_creatByDao;
    }

    public void updatePwd() throws SQLException {

        Connection jdbcConnection = JDBCHelper.JDBCConnection();
        String sql = "update user set u_name='Effy' where u_id=1001";
        Statement crunchifyPrepareStat = jdbcConnection.createStatement();
        crunchifyPrepareStat.executeUpdate(sql);


    }
}

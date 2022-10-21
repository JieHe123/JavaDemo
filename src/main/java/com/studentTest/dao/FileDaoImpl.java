package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FileDaoImpl implements FileDao {
    @Override
    public ArrayList<User> getAllStudent() {
        ArrayList<User> arr = new ArrayList<>();
        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
            String sql = "select * from user";
            PreparedStatement crunchifyPrepareStat = jdbcConnection.prepareStatement(sql);
            //crunchifyPrepareStat.setString(1, "");
            ResultSet rs = crunchifyPrepareStat.executeQuery();
            while (rs.next()) {
                User user = new User();
                int uid = rs.getInt("u_id");
                user.setU_id(uid);
                String name = rs.getString("u_name");
                user.setU_name(name);
                String pwd = rs.getString("u_pwd");
                user.setU_pwd(pwd);
                String phone = rs.getString("u_phone");
                user.setU_phone(phone);
                arr.add(user);
            }
        } catch (Exception e) {
        }
        return arr;
    }

    @Override
    public User getFileByNameOrId(String v) {

        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
            String sql = "select * from user where u_name='" + v + "' OR u_id='" + v + "'";
            PreparedStatement crunchifyPrepareStat = jdbcConnection.prepareStatement(sql);
            //crunchifyPrepareStat.setString(1, "");
            ResultSet rs = crunchifyPrepareStat.executeQuery();
            while (rs.next()) {
                User user2 = new User();
                int uid = rs.getInt("u_id");
                user2.setU_id(uid);
                String name = rs.getString("u_name");
                user2.setU_name(name);
                String pwd = rs.getString("u_pwd");
                user2.setU_pwd(pwd);
                String phone = rs.getString("u_phone");
                user2.setU_phone(phone);
                return user2;

            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public User getAdmin(String id) {
        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
            String sql = "select * from user where u_id='" + id + "'";
            PreparedStatement crunchifyPrepareStat = jdbcConnection.prepareStatement(sql);
            //crunchifyPrepareStat.setString(1, "");
            ResultSet rs = crunchifyPrepareStat.executeQuery();
            while (rs.next()) {
                User user2 = new User();
                int uid = rs.getInt("u_id");
                user2.setU_id(uid);
                String name = rs.getString("u_name");
                user2.setU_name(name);
                String pwd = rs.getString("u_pwd");
                user2.setU_pwd(pwd);
                String phone = rs.getString("u_phone");
                user2.setU_phone(phone);
                return user2;

            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        ArrayList<Major> arr = new ArrayList<>();
        try {
            Connection jdbcConnection = JDBCHelper.JDBCConnection();
            String sql = "SELECT c_name courseName,c_score score FROM" +
                    " course a, userchose b WHERE a.c_id=b.c_id AND b.u_id=" + studentId;
            PreparedStatement crunchifyPrepareStat = jdbcConnection.prepareStatement(sql);
            //crunchifyPrepareStat.setString(1, "");
            ResultSet rs = crunchifyPrepareStat.executeQuery();
            Major m = new Major();

            while (rs.next()) {

                m.setA(rs.getString("courseName"));
                m.setB(rs.getString("score"));
                arr.add(m);


            }
        } catch (Exception e) {
        }
        return arr;
    }

}

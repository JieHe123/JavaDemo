package com.studentTest.service;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

import java.util.ArrayList;

public class FileServiceImpl implements FileService {
    FileDao fd = new FileDaoImpl();

    @Override
    public ArrayList<User> getAllStudent() {

        return fd.getAllStudent();

    }


    @Override
    public User getFileByNameOrId(String v) {

        return fd.getFileByNameOrId(v);
    }

    @Override
    public User getFileByNameOrId() {
        return null;
    }

    @Override
    public User getAdmin(String id) {
        return fd.getAdmin(id);
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        return fd.getPersonFile(studentId);

    }
}

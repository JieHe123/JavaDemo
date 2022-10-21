package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.loginDao;
import com.studentTest.dao.loginDaoImpl;

public class loginServiceINosqlmpl implements loginService {


    @Override
    public User loginService(User user_from_Servelet) {
        loginDao ld = new loginDaoImpl();
        User user_createBy_service = ld.loginDao(user_from_Servelet);
        return user_createBy_service;
    }

}

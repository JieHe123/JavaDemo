package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class loginServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        String u_id_from_html = req.getParameter("html_u_id");
        String u_pwd_from_html = req.getParameter("html_u_pwd");
        User u_param = new User();
        int uid_int = Integer.valueOf(u_id_from_html);
        u_param.setU_id(uid_int);
        u_param.setU_pwd(u_pwd_from_html);
        loginService l = new loginServiceImpl();
        User user_from_Service = l.loginService(u_param);
        if (user_from_Service != null) {
            FileService fs = new FileServiceImpl();
            ArrayList<User> arr = fs.getAllStudent();
            req.setAttribute("user", user_from_Service);
            req.setAttribute("arr", arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "账户和密码不一致");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("导入doget");

    }

}

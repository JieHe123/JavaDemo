package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/mainServelet")
public class MainServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        String v = req.getParameter("v");
        FileService fs = new FileServiceImpl();
        User u = fs.getFileByNameOrId(v);
        ArrayList<User> arr = new ArrayList<User>();
        arr.add(u);
        String id = req.getParameter("id");
        FileService fs2 = new FileServiceImpl();
        User adminU = fs2.getAdmin(id);
        req.setAttribute("user", adminU);
        if (u != null) {
            req.setAttribute("arr", arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);

        } else {
            FileService f = new FileServiceImpl();
            ArrayList<User> arr2 = f.getAllStudent();
            req.setAttribute("arr", arr2);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);

        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("导入doget");

    }
}

package com.atshijie.controller;

import com.atshijie.constants.MyConstants;
import com.atshijie.pojo.SysUser;
import com.atshijie.service.SysUserService;
import com.atshijie.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
    private SysUserService userService = new SysUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SysUser sysUser = userService.login(username,password);

        if (sysUser != null) {
            req.getSession().setAttribute(MyConstants.LOGIN_USER_NAME, sysUser);

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }

    }
}

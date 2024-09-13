package com.atshijie.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/checkUsername")
public class CheckUserNameController  extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");

        String info = "<font color='green'>用户名可用</font>";
        if(username.equals("atguigu")){
            info = "<font color='red'>用户名被占用</font>";

        }


        resp.getWriter().write(info);
    }
}


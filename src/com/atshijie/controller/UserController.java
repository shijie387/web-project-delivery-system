package com.atshijie.controller;

import com.atshijie.pojo.SysUser;
import com.atshijie.service.SysUserService;
import com.atshijie.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.io.IOException;

//username=xiaohua&password=654321&nickname=hua
@WebServlet("/user/add")
public class UserController extends HttpServlet {
    SysUserService sysUserService = new SysUserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        SysUser sysUser = new SysUser(null, username, password, nickname);

        sysUserService.addNewUser(sysUser);

        resp.getWriter().write("add success");
    }
}

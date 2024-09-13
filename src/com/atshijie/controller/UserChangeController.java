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

@WebServlet("/user/change")
public class UserChangeController extends HttpServlet {
    private SysUserService sysUserService =new SysUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收参数
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        SysUser user = (SysUser)req.getSession().getAttribute(MyConstants.LOGIN_USER_NAME);



        // 调用服务层,修改该密码 ,跳转到页面 提示修改成功
        int rows =sysUserService.updatePasswordByUserId(user,oldPassword,newPassword);
        // 判断逻辑
        if(rows > 0){
            // 跳转页面提示修改成功
            req.setAttribute("successMsg","修改成功");
            req.getRequestDispatcher("/password.jsp").forward(req,resp);
        }else{
            // 跳转页面提示 旧密码有误,修改该失败
            req.setAttribute("errorMsg","修改失败");
            req.getRequestDispatcher("/password.jsp").forward(req,resp);

        }



    }
}

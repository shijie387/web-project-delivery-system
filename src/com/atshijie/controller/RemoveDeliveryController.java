package com.atshijie.controller;

import com.atshijie.service.SysDeliveryService;
import com.atshijie.service.impl.SysDeliveryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/data/remove")
public class RemoveDeliveryController extends HttpServlet {
    private SysDeliveryService deliveryService =new SysDeliveryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        // 调用服务层 处理删除业务
        deliveryService.removeById(id);

        // 重定向
        resp.sendRedirect(req.getContextPath()+"/data/list");

    }
}

package com.atshijie.controller;


import com.atshijie.constants.MyConstants;
import com.atshijie.pojo.SysDelivery;
import com.atshijie.pojo.SysUser;
import com.atshijie.service.SysDeliveryService;
import com.atshijie.service.impl.SysDeliveryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/data/list")
public class DeliveryListController extends HttpServlet {
    private SysDeliveryService deliveryService= new SysDeliveryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get current login info
        HttpSession session = req.getSession();
        SysUser sysUser = (SysUser) session.getAttribute(MyConstants.LOGIN_USER_NAME);
        Integer id = sysUser.getId();

        //calling method in service
        List<SysDelivery> deliveryList = deliveryService.findByUserId(id);

        req.setAttribute("deliveryList", deliveryList);

        //show delivery info
//        deliveryList.forEach(System.out::println);

        //forward to another page
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}

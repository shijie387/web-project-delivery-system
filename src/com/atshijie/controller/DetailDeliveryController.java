package com.atshijie.controller;

import com.atshijie.pojo.SysCompany;
import com.atshijie.pojo.SysDelivery;
import com.atshijie.service.SysCompanyService;
import com.atshijie.service.SysDeliveryService;
import com.atshijie.service.impl.SysCompanyServiceImpl;
import com.atshijie.service.impl.SysDeliveryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/data/detail")
public class DetailDeliveryController extends HttpServlet {
    private SysDeliveryService deliveryService =new SysDeliveryServiceImpl();
    private SysCompanyService companyService =new SysCompanyServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        // 调用业务层方法,根据id找到完整的快递信息
        SysDelivery delivery =deliveryService.findById(id);
        // 调用业务层方法,查询所有的快递公司
        List<SysCompany> companyList = companyService.findAll();
        // 将快递信息和公司信息 放入请求域 请求转发到edit.jsp
        req.setAttribute("delivery",delivery);
        req.setAttribute("companyList",companyList);
        req.getRequestDispatcher("/edit.jsp").forward(req,resp);

    }
}

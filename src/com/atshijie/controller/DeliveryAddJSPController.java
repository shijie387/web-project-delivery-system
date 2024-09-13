package com.atshijie.controller;

import com.atshijie.pojo.SysCompany;
import com.atshijie.service.SysCompanyService;
import com.atshijie.service.impl.SysCompanyServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/data/addjsp")
public class DeliveryAddJSPController extends HttpServlet {
    private SysCompanyService sysCompanyService = new SysCompanyServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SysCompany> companyList = sysCompanyService.findAll();

        req.setAttribute("companyList", companyList);

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }
}

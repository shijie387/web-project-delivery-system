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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/data/save")
public class SaveDeliveryController extends HttpServlet {
    private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    private SysDeliveryService deliveryService =new SysDeliveryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要新增的快递的数据
        SysDelivery delivery =new SysDelivery();

        delivery.setDeliveryName( req.getParameter("deliveryName"));
        SysUser user = (SysUser)req.getSession().getAttribute(MyConstants.LOGIN_USER_NAME);
        delivery.setUserId(user.getId());
        delivery.setCompanyId(Integer.parseInt(req.getParameter("companyId")));
        delivery.setPhone(req.getParameter("phone"));
        delivery.setAddress(req.getParameter("address"));
        delivery.setSendTime(new Date());
        try {
            delivery.setSendTime(sdf.parse(req.getParameter("sendTime"))); // yyyy-MM-dd
        } catch (ParseException e) {
            //throw new RuntimeException(e);
            System.out.println("日期信息转换异常,已经使用系统默认时间");
        }
        delivery.setState(Integer.parseInt(req.getParameter("state")));



        // 调用服务层方法,将处理增加快递业务
        deliveryService.save(delivery);
        // 跳转页面
        resp.sendRedirect(req.getContextPath()+"/data/list");

    }
}

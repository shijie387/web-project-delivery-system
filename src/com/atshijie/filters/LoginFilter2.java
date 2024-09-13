package com.atshijie.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = {"*.jsp","/data/*","/user/change","user/logout"})
public class LoginFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
                response.sendRedirect("/delivery/login.html");
            }
        }

}

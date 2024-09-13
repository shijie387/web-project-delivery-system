package com.atshijie.filters;

import com.atshijie.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            String requestURI = request.getRequestURI();
            if(
                    requestURI.endsWith("login.html") ||
                    requestURI.endsWith("/user/login") ||
                    requestURI.contains("/js/") ||
                    requestURI.contains("/css/") ||
                    requestURI.contains("/images/")||
                    requestURI.contains("/user/CheckUsername")

            ){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                response.sendRedirect("/delivery/login.html");
            }
        }

    }
}

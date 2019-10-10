package com.Criss75.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implements a filter for login
 */
@WebFilter(urlPatterns = {"/todo"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        Object isAuthenticated = httpReq.getSession().getAttribute("isAuth");
        if(isAuthenticated == null || !Boolean.valueOf(isAuthenticated.toString())) {
            ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/signin");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

package com.Criss75.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * logout class
 */
@WebServlet(urlPatterns = "/logout")
    public class LogoutServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getSession().setAttribute("isAuth", false);
            req.setAttribute("logout_message", "You have successfully logout!");
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        }

    }


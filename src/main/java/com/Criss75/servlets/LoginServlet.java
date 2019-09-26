package com.Criss75.servlets;

import com.Criss75.dao.UserDaoImpl;
import com.Criss75.todoController.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDaoImpl userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String path = "/TodoController";
        if (userDao.validateLogin(username, password)) {
            req.getSession().setAttribute("isAuth", true);
            req.getSession().setAttribute("userProfile", userDao.getUserProfile(username, password));
            resp.sendRedirect(req.getContextPath() + path);
//            rd.forward(req, resp);
        } else {
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        }
    }

}



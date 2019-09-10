package com.Criss75.servlets;

import com.Criss75.dao.UserDao;
import com.Criss75.dao.UserDaoImpl;
import com.Criss75.user.UserAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/signup"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDaoImpl userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setEmail(email);
        userAccount.setPassword(password);

        try {
            userDao.registerUser(userAccount);
            request.setAttribute("success", "You have registered successfully! Please login");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
            rd.forward(request, response);
    }
}

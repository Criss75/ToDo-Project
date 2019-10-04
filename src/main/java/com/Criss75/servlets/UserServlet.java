package com.Criss75.servlets;

import com.Criss75.dao.UserDaoImpl;
import com.Criss75.entity.UserAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that takes care of authentication
 */
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

    /**
     * method that checks if entity name or email already exits, if initial password match retyped password
     * if yes, entity is logged in and forwarded to todo-list
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException exception
     * @throws IOException      IO exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("re_pass");

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setEmail(email);
        userAccount.setPassword(password);

        if (!userDao.isUserNameValid(username)) {
            request.setAttribute("error_username", "User already taken, please choose another one!");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        } else if (!userDao.isEmailValid(email)) {
            request.setAttribute("error_email", "Email already registered!");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        } else if (!password.equals(retypePassword)) {
            request.setAttribute("error_password", "Password does not match initial password!");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        } else {
            try {
                userDao.registerUser(userAccount);
                request.setAttribute("success", "You have registered successfully! Please login");
                RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

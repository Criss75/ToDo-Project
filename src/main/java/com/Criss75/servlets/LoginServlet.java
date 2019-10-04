package com.Criss75.servlets;

import com.Criss75.dao.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin")

/**
 * Login servlet that takes care of authentication process. If entity/password are valid, it is forwarded
 * to the controller servlet, else it is forwarded back to the login servlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDaoImpl userDao;

    /**
     * Overriding init method
     */
    public void init() {
        userDao = new UserDaoImpl();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signin.jsp").forward(req, resp);
    }

    /**
     * checks if entity/password is valid. If true, entity can access his own todo list, else it is forwarded back to
     * login page
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException exception
     * @throws IOException io Exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String path = "/todo";
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



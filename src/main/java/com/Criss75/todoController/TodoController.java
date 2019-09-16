package com.Criss75.todoController;

import com.Criss75.dao.TodoDaoImpl;
import com.Criss75.user.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/TodoController")
public class TodoController extends HttpServlet {
    private static final long serialVersionUID =1L;

    TodoDaoImpl todoDao = null;

    public TodoController() {
        todoDao = new TodoDaoImpl();
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Todo> list = todoDao.get();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/todo-list.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todoName = req.getParameter("todoname");
        Boolean completed = Boolean.parseBoolean(req.getParameter("completed"));
        String active = req.getParameter("active");
        Todo todo = new Todo();
        todo.setTitle(todoName);
        todo.setIs_complete(completed);
        todo.setActive(active);
        if (todoDao.save(todo)){
            req.setAttribute("message",  "Saved successfully");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/todo-add.jsp");
        dispatcher.forward(req, resp);

    }
}

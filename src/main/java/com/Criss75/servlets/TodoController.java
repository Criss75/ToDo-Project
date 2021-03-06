package com.Criss75.servlets;

import com.Criss75.dao.TodoDaoImpl;
import com.Criss75.entity.Todo;
import com.Criss75.entity.UserAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * todo controller that takes care of the main operation on todo's. Implements CRUD
 * (create, read, update, delete) for entity todo's
 */
@WebServlet(urlPatterns = {"/todo"}, initParams = {@WebInitParam(name="user_id",value="account.getUserId")})
public class TodoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RequestDispatcher requestDispatcher;
    private TodoDaoImpl todoDao;

    public TodoController() {
        todoDao = new TodoDaoImpl();
        requestDispatcher = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "LIST";
        }

        switch (action) {
            case "EDIT":
                getSingleTodo(req, resp);
                break;
            case "DELETE":
                deleteTodo (req,resp);
                break;
            case "ADD":
                req.getRequestDispatcher("/todo-add.jsp").forward(req,resp);
                break;

            default:
                listTodos(req, resp);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todoId = req.getParameter("todo_id");
        String todoName = req.getParameter("todoname");
        boolean completed = Boolean.parseBoolean(req.getParameter("completed"));
        String active = req.getParameter("active");

        Todo todo = new Todo();
        UserAccount userAccount = (UserAccount) req.getSession().getAttribute("userProfile");
        int userId = userAccount.getUserId();
        todo.setUserId(userId);
        todo.setTitle(todoName);
        todo.setComplete(completed);
        todo.setActive(active);

        if(todoId == null) {
            if (todoDao.save(todo)) {
                req.setAttribute("message", "Saved successfully");
            }
        } else {
            todo.setTodoId(Integer.parseInt(todoId));
            if (todoDao.update(todo)) {
                req.setAttribute("message", "Updated successfully");
            }
        }

        listTodos(req, resp);
    }

    /**
     * method that lists all entity todo's
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException exception
     * @throws IOException IO exception
     */
    private void listTodos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAccount userAccount = (UserAccount) req.getSession().getAttribute("userProfile");
        int userId = userAccount.getUserId();
        List<Todo> list = todoDao.getAll(userId);
        req.setAttribute("list", list);
        requestDispatcher = req.getRequestDispatcher("/todo-list.jsp");
        requestDispatcher.forward(req, resp);
    }

    /**
     * method that retrieves a single todo
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException exception
     * @throws IOException IO exception
     */
    private void getSingleTodo (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todoId = req.getParameter("todo_id");
        Todo todo = todoDao.get(Integer.parseInt(todoId));
        req.setAttribute("todo", todo);
        requestDispatcher = req.getRequestDispatcher("/todo-add.jsp");
        requestDispatcher.forward(req, resp);
    }

    /**
     * method that deletes todo's
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException exception
     * @throws IOException IO exception
     */
    private void deleteTodo (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo_id = req.getParameter("todo_id");
        if (todoDao.delete(Integer.parseInt(todo_id))) {
            req.setAttribute("message", "Todo has been deleted");
        }
    listTodos(req, resp);
    }
}

package com.Criss75.dao;

import com.Criss75.user.Todo;
import com.Criss75.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implements TodoDao interface
 * Contains methods to: "list all", "save", "retrieve a single todo", "update", "delete" todo's
 */
public class TodoDaoImpl implements TodoDao {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    /**
     * Connects to database to retrieve all todo's on a user ID
     * Sorts the todo's retrieved based on their completion date (column label "active")
     */
    @Override
    public List<Todo> getAll(int userId) {
        List<Todo> list = null;
        Todo todo;

        try {
            list = new ArrayList<>();
            String sql = "SELECT * FROM todo WHERE user_id = ?";
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                todo = new Todo();
                todo.setUserId(resultSet.getInt("user_id"));
                todo.setTodoId(resultSet.getInt("todo_id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setComplete(resultSet.getBoolean("is_complete"));
                todo.setActive(resultSet.getString("active"));

                list.add(todo);

                Comparator<Todo> todoComparator = new Comparator<Todo>() {
                    @Override
                    public int compare(Todo todo1, Todo todo2) {
                        return todo1.getActive().compareTo(todo2.getActive());
                    }
                };

                list.sort(todoComparator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * method that saves a todo into database
     * @param todo todo
     * @return flag (true if saving has been completed, else false)
     */
    @Override
    public boolean save(Todo todo) {
        boolean flag = false;
        try  {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO todo (user_id, title, is_complete, active)" +
                    " VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, todo.getUserId());
            preparedStatement.setString(2, todo.getTitle());
            preparedStatement.setBoolean(3, todo.isComplete());
            preparedStatement.setString(4, todo.getActive());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();
        } catch (SQLException e) {

            e.printStackTrace();
        } return flag;
    }

    /**
     * method that gets a single todo from database
     */
    @Override
    public Todo get(int todoId) {
        Todo todo = null;
        try {
            todo = new Todo();
            String sql ="SELECT * FROM todo WHERE todo_id=" + todoId;
            connection = DBConnectionUtil.openConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                todo.setTodoId(resultSet.getInt("todo_id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setComplete(resultSet.getBoolean("is_complete"));
                todo.setActive(resultSet.getString("active"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    /**
     * Method to update a todo
     * @param todo todo
     * @return flag true if update is successful else false
     */
    @Override
    public boolean update(Todo todo) {
        boolean flag =false;
        try {
            String sql = "UPDATE todo SET title='"+todo.getTitle()+"', is_complete='"+todo.isComplete()+"', " +
                    "active ='"+todo.getActive()+"' WHERE todo_id="+todo.getTodoId();
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } return flag;
    }

    /**
     * Method to delete a todo
     * @param todoId todo ID
     * @return flag true if delete successful else false
     */
    @Override
    public boolean delete(int todoId) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM todo WHERE todo_id="+ todoId;
            connection=DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        } return flag;
    }
}

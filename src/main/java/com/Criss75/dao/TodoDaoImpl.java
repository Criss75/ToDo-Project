package com.Criss75.dao;

import com.Criss75.user.Todo;
import com.Criss75.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

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

    @Override
    public Todo get(int todoId) {
        Todo todo = null;
        try {
            todo = new Todo();
            String sql ="SELECT * FROM todo WHERE todo_id=" + todoId;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
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

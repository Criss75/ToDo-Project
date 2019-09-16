package com.Criss75.dao;

import com.Criss75.user.Todo;
import com.Criss75.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Todo> get() {
        List<Todo> list = null;
        Todo todo = null;

        try {
            list = new ArrayList<Todo>();

            String sql = "SELECT * FROM todo";

            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                todo = new Todo();
                todo.setUser_id(resultSet.getInt("user_id"));
                todo.setTodo_id(resultSet.getInt("todo_id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setIs_complete(resultSet.getBoolean("is_complete"));
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
            preparedStatement = connection.prepareStatement("INSERT INTO todo (title, is_complete, active)" +
                    " VALUES (?, ?, ?)");
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setBoolean(2, todo.isIs_complete());
            preparedStatement.setString(3, todo.getActive());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } return flag;
    }
}

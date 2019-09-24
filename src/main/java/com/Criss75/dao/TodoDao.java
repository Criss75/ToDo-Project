package com.Criss75.dao;

import com.Criss75.user.Todo;

import java.util.List;

public interface TodoDao {
    List<Todo> getAll(int user_id);
    boolean save(Todo todo);
    Todo get(int todoId);
    boolean update (Todo todo);
    boolean delete (int todoId);
}

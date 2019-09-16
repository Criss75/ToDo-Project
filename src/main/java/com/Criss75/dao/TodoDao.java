package com.Criss75.dao;

import com.Criss75.user.Todo;

import java.util.List;

public interface TodoDao {
    List<Todo> get();
    boolean save(Todo todo);
}

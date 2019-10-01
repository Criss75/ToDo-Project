package com.Criss75.dao;

import com.Criss75.user.Todo;

import java.util.List;

/**
 * Creating Data Access Object interface
 * Marks the methods available on a todo item
 */
public interface TodoDao {

    /**
     * Get a list of all todo's based on an user ID
     * @param user_id user ID
     */
    List<Todo> getAll(int user_id);

    /**
     * Save a new todo
     * @param todo todo
     */
    boolean save(Todo todo);

    /**
     * Get a single todo based on a user ID
     * @param todoId todo ID
     */
    Todo get(int todoId);

    /**
     * Updates an existing todo
     * @param todo todo
     */
    boolean update (Todo todo);

    /**
     * Deletes a selected todo based on todo's ID
     * @param todoId todo ID
     */
    boolean delete (int todoId);
}

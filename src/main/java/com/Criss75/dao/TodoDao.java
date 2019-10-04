package com.Criss75.dao;

import com.Criss75.entity.Todo;

import java.util.List;

/**
 * Creating Data Access Object interface
 * Marks the methods available on a todo item
 */
public interface TodoDao {

    /**
     * Get a list of all todo's based on an entity ID
     * @param user_id entity ID
     */
    List<Todo> getAll(int user_id);

    /**
     * Save a new todo
     * @param todo todo
     */
    boolean save(Todo todo);

    /**
     * Get a single todo based on a entity ID
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

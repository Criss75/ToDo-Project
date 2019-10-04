package com.Criss75.dao;

import com.Criss75.entity.UserAccount;

/**
 * Creating Data Access Object interface
 * Marks the methods available on a entity item
 */
public interface UserDao {

    /**
     * register a entity based on an UserAccount object
     * @param userAccount object that defines the entity
     */
    int registerUser (UserAccount userAccount);

    /**
     * validates an entity login based on entity name and password
     * @param name entity name
     * @param password entity password
     */
    boolean validateLogin (String name, String password);

    /**
     * Checks if entity name is valid (not present in the database)
     * @param name entity name
     */
    boolean isUserNameValid(String name);

    /**
     * Checks if entity email is valid (not present in the database)
     * @param email entity email
     */
    boolean isEmailValid(String email);
}

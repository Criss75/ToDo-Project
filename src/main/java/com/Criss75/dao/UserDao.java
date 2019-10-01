package com.Criss75.dao;

import com.Criss75.user.UserAccount;

/**
 * Creating Data Access Object interface
 * Marks the methods available on a user item
 */
public interface UserDao {

    /**
     * register a user based on an UserAccount object
     * @param userAccount object that defines the user
     */
    int registerUser (UserAccount userAccount);

    /**
     * validates an user login based on user name and password
     * @param name user name
     * @param password user password
     */
    boolean validateLogin (String name, String password);

    /**
     * Checks if user name is valid (not present in the database)
     * @param name user name
     */
    boolean isUserNameValid(String name);

    /**
     * Checks if user email is valid (not present in the database)
     * @param email user email
     */
    boolean isEmailValid(String email);
}

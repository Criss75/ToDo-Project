package com.Criss75.dao;

import com.Criss75.user.UserAccount;

public interface UserDao {
    int registerUser (UserAccount userAccount);
    boolean validateLogin (String name, String password);
    boolean isUserNameValid(String name);
}

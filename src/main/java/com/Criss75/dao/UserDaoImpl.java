package com.Criss75.dao;

import com.Criss75.user.UserAccount;
import com.Criss75.util.DBConnectionUtil;

import java.sql.*;

/**
 * Class to implement UserDao
 * Contains methods to: get a single user object based on user ID,
 */
public class UserDaoImpl implements UserDao {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    /**
     * method that registers a user in the database
     * @param userAccount object that defines the user
     * @return - user object newly created in the database
     */
    @Override
    public int registerUser(UserAccount userAccount) {
        String INSERT_USERS_SQL = "INSERT INTO account" +
                "  (username, email, password) VALUES " +
                " (?, ?, ?);";
        int result = 0;
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
//            preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, userAccount.getUsername());
            preparedStatement.setString(2, userAccount.getEmail());
            preparedStatement.setString(3, userAccount.getPassword());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    /**
     * method that validates the login based on registered user name information
     * @param name user name
     * @param password user password
     * @return - if the login details are correct (by checking user name/password pair in the database)
     */
    @Override
    public boolean validateLogin(String name, String password) {
        boolean status = false;
        String SELECT_USERS_SQL = "SELECT * FROM account WHERE username=? and password=?;";
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * method that checks if user name is already taken or it is free in the database
     * @param name user name
     * @return - status true if username is available, else false
     */
    @Override
    public boolean isUserNameValid(String name) {
        boolean status = true;
        String SELECT_USERS_SQL = "SELECT * FROM account WHERE username=?;";
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                status =false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * method that checks if user email is already taken or it is free in the database
     * @param email user email
     * @return - status true if user email is available, else false
     */
    @Override
    public boolean isEmailValid(String email) {
        boolean status = true;
        String SELECT_USERS_SQL = "SELECT * FROM account WHERE email=?;";
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                status =false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * method that collects possible SQL exceptions
     * @param ex exception
     */
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    /**
     * method that retrieves from database a user with all information
     * @param name user name
     * @param password user password
     * @return user object
     */
    public UserAccount getUserProfile (String name, String password) {
        UserAccount profile = null;
        String SELECT_USERS_SQL = "SELECT * FROM account WHERE username=? and password=?;";
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean profileExists = resultSet.next();
            if(profileExists) {
                profile = new UserAccount();
                profile.setUserId(resultSet.getInt(1));
                profile.setUsername(resultSet.getString(2));
                profile.setEmail(resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }
}

package com.Criss75.dao;

import com.Criss75.user.UserAccount;
import com.Criss75.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

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
            System.out.println(e);
        }
        return status;
    }

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
}

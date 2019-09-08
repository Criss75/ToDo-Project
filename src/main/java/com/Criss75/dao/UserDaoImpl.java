package com.Criss75.dao;

import com.Criss75.user.UserAccount;
import com.Criss75.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public int registerUser(UserAccount userAccount) {
        String INSERT_USERS_SQL = "INSERT INTO account" +
                "  (user_id, username, email, password) VALUES " +
                " (?, ?, ?, ?);";
        int result = 0;
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, userAccount.getUsername());
            preparedStatement.setString(3, userAccount.getEmail());
            preparedStatement.setString(4, userAccount.getPassword());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
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

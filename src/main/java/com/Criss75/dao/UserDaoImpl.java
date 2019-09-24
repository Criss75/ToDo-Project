package com.Criss75.dao;

import com.Criss75.user.UserAccount;
import com.Criss75.util.DBConnectionUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public UserAccount get(int id) {
        UserAccount user =null;
        try {
            user = new UserAccount();
            String sql = "SELECT * FROM account WHERE user_id=" +id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet=statement.executeQuery(sql);
            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return user;
    }

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
            System.out.println(e);
        }
        return profile;
    }
}

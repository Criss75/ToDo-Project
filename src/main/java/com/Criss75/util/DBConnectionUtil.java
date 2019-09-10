package com.Criss75.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/todo";
    private static final String DRIVER ="org.postgresql.Driver";
    private static final String USERNAME ="postgres";
    private static final String PASSWORD ="C*-ardigans2";
    private static Connection connection = null;

    public static Connection openConnection() {
        if (connection!=null) {
            return connection;
        } else {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return connection;
        }
    }
}
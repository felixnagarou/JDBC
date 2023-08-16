package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection getPostgreSQLConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Exo_JDBC";
        String user = "postgres";
        String password = "";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}

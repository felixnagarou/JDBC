package Exercice002;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URI = "jdbc:postgresql://localhost:5432/Exo_JDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
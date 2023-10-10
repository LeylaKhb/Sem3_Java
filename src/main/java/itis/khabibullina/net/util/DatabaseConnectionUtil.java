package itis.khabibullina.net.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/test_itis",
                        "postgres",
                        "postgres"
                );
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}

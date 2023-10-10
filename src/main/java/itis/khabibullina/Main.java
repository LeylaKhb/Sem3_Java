package itis.khabibullina;

import itis.khabibullina.net.client.HttpClientImpl;
import itis.khabibullina.net.model.User;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/test_itis",
                "postgres",
                "postgres"
        );

        Statement statement = connection.createStatement();
        String sql = "SELECT * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        List<User> users = new ArrayList<>();


        if (resultSet != null) {
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("lastname"),
                                resultSet.getString("email"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                                )
                );
            }
        }
    }
}
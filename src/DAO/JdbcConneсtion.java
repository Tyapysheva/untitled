package DAO;

import java.sql.*;

public class JdbcConneсtion {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/reservation_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        return connection;
    }
}

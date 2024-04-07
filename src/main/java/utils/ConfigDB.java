package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection provideConnection() throws ClassNotFoundException {
        Connection conn;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_advance?autoReconnect=true&useSSL=false", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}

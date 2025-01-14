package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root"; // Database username
    private static final String PASSWORD = "8989"; // Database password
    private static final String URL = "jdbc:mysql://localhost:3306/db_agenda"; // Database URL

    // Static method to establish a connection to the database
    public static Connection connectionToMyDb() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get a connection to the database
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
            throw new RuntimeException(e);

        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

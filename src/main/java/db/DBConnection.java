package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Cargar el controlador JDBC
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // private static final String url = "jdbc:mysql://localhost:3306/Evaluacion2";
    
    private static final String url = "jdbc:mysql://10.0.2.15:3306/Evaluacion2";
    private static final String user = "root";
    private static final String password = "Jmcstolz99@";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

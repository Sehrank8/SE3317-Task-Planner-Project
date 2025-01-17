import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

        static String url = "jdbc:mysql://localhost:3306/project";
        static String username = "root";
        static String password = "12345678";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
        }
}

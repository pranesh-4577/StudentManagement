import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root"; 
        String password = "ROOT123";
        
        return DriverManager.getConnection(url, user, password);
    }
}
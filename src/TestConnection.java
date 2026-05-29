import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Database Connected Successfully!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Connection Failed!");

            System.out.println(e);
        }
    }
}

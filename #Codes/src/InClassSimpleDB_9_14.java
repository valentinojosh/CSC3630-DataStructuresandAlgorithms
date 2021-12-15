import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InClassSimpleDB_9_14 {
    public static void main(String[] args) {
        String databaseURL = "jdbc:mysql://45.55.136.114:3306/csc3610";
        String user = "csc3610";        //String password = "data123456";
        String password = "csc3610";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}

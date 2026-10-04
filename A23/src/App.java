import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String pswd = "purabP@$$W0rd";

        String sql = "SELECT * FROM STUDENTS";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(db, user, pswd);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("Connection established \n");

                while (rs.next()) {

                    System.out.println("ID = " + rs.getInt("ID"));

                    System.out.println("NAME = " + rs.getString("NAME"));

                    System.out.println("AGE = " + rs.getInt("AGE"));

                    System.out.println("COURSE = " + rs.getString("COURSE"));

                }
            }

        } catch (SQLException e) {

            System.out.println("Database Error:");

        } catch (ClassNotFoundException e) {

            System.out.println("Not found:");
        }
    }
}
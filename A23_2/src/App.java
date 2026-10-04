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

        String sql =
                "SELECT ID, NAME, DEPARTMENT, SALARY FROM EMPLOYEES";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(db, user, pswd);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    System.out.println("Employee ID = " + rs.getInt("ID"));

                    System.out.println("Name = " +rs.getString("NAME"));

                    System.out.println("Department = " +rs.getString("DEPARTMENT"));

                    System.out.println("Salary = " + rs.getInt("SALARY"));

                    System.out.println("");
                }
            }

        } catch (SQLException e) {

            System.out.println("Database Error:");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            System.out.println("JDBC Driver not found:");
            e.printStackTrace();
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String pswd = "purabP@$$W0rd";

        Connection con = DriverManager.getConnection(db, user, pswd);

        String query = "SELECT * FROM students";

        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        System.out.println("Student Records:");

        while (rs.next()) {
            System.out.println("ID     : " + rs.getInt("id"));
            System.out.println("Name   : " + rs.getString("name"));
            System.out.println("Age    : " + rs.getInt("age"));
            System.out.println("Course : " + rs.getString("course"));
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
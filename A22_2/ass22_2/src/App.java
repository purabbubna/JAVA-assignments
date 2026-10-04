import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String db = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String pswd = "purabP@$$W0rd";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String usnm = sc.next();
        System.out.print("Enter password: ");
        int ps = sc.nextInt();
       
        String select_query = "select count(*) from login where usname = ? and pswd = ?;";
        Connection con = DriverManager.getConnection(db, user, pswd);
        if (con != null) {
            
            PreparedStatement myStmt = con.prepareStatement(select_query);

            myStmt.setString(1, usnm);
            myStmt.setInt(2, ps);

            ResultSet rs = myStmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                if (count > 0) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Invalid username or password");
                }
            }

            rs.close();
            myStmt.close();
            con.close();
            sc.close();
        } else {
            System.out.println("Connection not established");
        }
    }
}

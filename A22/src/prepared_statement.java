import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prepared_statement {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String pswd = "purabP@$$W0rd";
        Connection con = DriverManager.getConnection(db, user, pswd);
        if (con != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username: ");
            String usnm = sc.next();
            System.out.print("Enter password: ");
            int ps = sc.nextInt();
            String query = "insert into login values(?,?)";
            PreparedStatement myStmt = con.prepareStatement(query);
            myStmt.setString(1, usnm);
            myStmt.setInt(2, ps);
            myStmt.execute();
            System.out.println("1 row inserted");
            myStmt.close();
            con.close();
            sc.close();
        } else {
            System.out.println("Connection not established");
        }
    }
}

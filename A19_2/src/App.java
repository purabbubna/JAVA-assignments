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

        String query = "SELECT product_id, product_name, quantity, price FROM products";

        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        System.out.println("Product Details");
        System.out.println("------------------------------------------");

        while (rs.next()) {
            System.out.println("Product ID   : " + rs.getInt("product_id"));
            System.out.println("Product Name : " + rs.getString("product_name"));
            System.out.println("Quantity     : " + rs.getInt("quantity"));
            System.out.println("Price        : " + rs.getDouble("price"));
            System.out.println("------------------------------------------");
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
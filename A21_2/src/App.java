import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/purab";
        String user = "root";
        String pswd = "purabP@$$W0rd";
        try{
            Connection con = DriverManager.getConnection(db, user, pswd);
            System.out.println("connected");
            System.out.println("done scenes");
            con.close();
        } catch (Exception e) {
            System.out.println("not connected");
        }
       
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    static void create_table(Connection con) throws SQLException {

        try (Statement st = con.createStatement()) {

            String sqlDrop = "DROP TABLE IF EXISTS STUDENT";
            st.executeUpdate(sqlDrop);

            String sqlCreate =
                    "CREATE TABLE STUDENT (" +
                    "ROLL_NO INT PRIMARY KEY NOT NULL, " +
                    "NAME VARCHAR(50) NOT NULL, " +
                    "COURSE VARCHAR(50) NOT NULL, " +
                    "MARKS INT)";

            st.executeUpdate(sqlCreate);

            System.out.println("table created successfully.");
        }
    }

    // CREATE 
    static void insert_table(Connection con) throws SQLException {

        String sql =
                "INSERT INTO STUDENT " +
                "(ROLL_NO, NAME, COURSE, MARKS) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 145);
            ps.setString(2, "Purab");
            ps.setString(3, "CSE");
            ps.setInt(4, 100);
            ps.executeUpdate();

            System.out.println("Student records inserted successfully.");
        }
    }

    // READ
    static void read_table(Connection con) throws SQLException {

        String sql = "SELECT * FROM STUDENT";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println("ROLL NO = " + rs.getInt("ROLL_NO"));

                System.out.println("NAME = " + rs.getString("NAME"));

                System.out.println("COURSE = " + rs.getString("COURSE"));

                System.out.println("MARKS = " + rs.getInt("MARKS"));

                System.out.println();
            }
        }
    }

    // UPDATE
    static void update_table(Connection con) throws SQLException {

        String sql =
                "UPDATE STUDENT SET MARKS = ? WHERE ROLL_NO = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 105);
            ps.setInt(2, 145);

            int rowsAffected = ps.executeUpdate();
        }
    }

    // DELETE
    static void delete_table(Connection con) throws SQLException {

        String sql =
                "DELETE FROM STUDENT WHERE ROLL_NO = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 145);

            int rowsAffected = ps.executeUpdate();
        }
    }

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/purab";
        String user = "root";
        String pswd = "purabP@$$W0rd";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(db, user, pswd)) {
                create_table(con);

                System.out.println("\nInserting Students ---");
                insert_table(con);

                System.out.println("\nReading Students ---");
                read_table(con);

                System.out.println("\nUpdating Student ---");
                update_table(con);

                System.out.println("\nReading After Update ---");
                read_table(con);

                System.out.println("\nDeleting Student ---");
                delete_table(con);
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
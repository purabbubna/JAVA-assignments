import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    static void create_table(Connection con) throws SQLException {

        try (Statement st = con.createStatement()) {

            String sqlDrop = "DROP TABLE IF EXISTS EMPLOYEE";
            st.executeUpdate(sqlDrop);

            String sqlCreate =
                    "CREATE TABLE EMPLOYEE (" +
                    "ID INT PRIMARY KEY NOT NULL, " +
                    "NAME VARCHAR(50) NOT NULL, " +
                    "AGE INT NOT NULL, " +
                    "DEPARTMENT VARCHAR(50), " +
                    "SALARY INT)";

            st.executeUpdate(sqlCreate);

            System.out.println("Employee table created successfully.");
        }
    }

    static void insert_table(Connection con) throws SQLException {

        String sql =
                "INSERT INTO EMPLOYEE " +
                "(ID, NAME, AGE, DEPARTMENT, SALARY) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 145);
            ps.setString(2, "purab");
            ps.setInt(3, 19);
            ps.setString(4, "CSE");
            ps.setInt(5, 1000000);
            ps.executeUpdate();
          
        }
    }

    static void read_table(Connection con) throws SQLException {

        String sql = "SELECT * FROM EMPLOYEE";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println("ID = " +
                        rs.getInt("ID"));

                System.out.println("NAME = " +
                        rs.getString("NAME"));

                System.out.println("AGE = " +
                        rs.getInt("AGE"));

                System.out.println("DEPARTMENT = " +
                        rs.getString("DEPARTMENT"));

                System.out.println("SALARY = " +
                        rs.getInt("SALARY"));

                System.out.println();
            }
        }
    }

    static void update_table(Connection con) throws SQLException {

        String sql =
                "UPDATE EMPLOYEE SET SALARY = ? WHERE ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 2000000);
            ps.setInt(2, 145);

            int rowsAffected = ps.executeUpdate();

        }
    }

    // DELETE
    static void delete_table(Connection con) throws SQLException {

        String sql =
                "DELETE FROM EMPLOYEE WHERE ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 145);

            int rowsAffected = ps.executeUpdate();

        }
    }

    public static void main(String[] args) {

        
        String db = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String pswd = "purabP@$$W0rd";

        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(db, user, pswd)) {

                System.out.println(
                        "Connection established successfully!\n");

                create_table(con);

                System.out.println("\nInserting Employees");
                insert_table(con);

                System.out.println("\n Reading Employees");
                read_table(con);

                System.out.println("\nUpdating Employee");
                update_table(con);

                System.out.println("\nReading After Update");
                read_table(con);

                System.out.println("\nDeleting Employee");
                delete_table(con);

                System.out.println("\nReading After Delete");
                read_table(con);

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
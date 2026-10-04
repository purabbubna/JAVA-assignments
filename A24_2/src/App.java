import javax.swing.*;
import java.sql.*;

public class App extends JFrame {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3, b4;

    Connection con;

    String db = "jdbc:mysql://localhost:3306/javajdbc";
    String user = "root";
    String pswd = "purabP@$$W0rd";

    App() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(db, user, pswd);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Book Issue Tracking System");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        l1 = new JLabel("Book ID:");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        l2 = new JLabel("Student Name:");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        l3 = new JLabel("Issue Date:");
        l3.setBounds(50, 150, 100, 30);
        add(l3);

        l4 = new JLabel("Return Date:");
        l4.setBounds(50, 200, 100, 30);
        add(l4);


        t1 = new JTextField();
        t1.setBounds(150, 50, 200, 30);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(150, 100, 200, 30);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(150, 150, 200, 30);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(150, 200, 200, 30);
        add(t4);

        b1 = new JButton("Add");
        b1.setBounds(50, 260, 80, 30);
        add(b1);

        b2 = new JButton("View");
        b2.setBounds(140, 260, 80, 30);
        add(b2);

        b3 = new JButton("Delete");
        b3.setBounds(230, 260, 80, 30);
        add(b3);

        b4 = new JButton("Clear");
        b4.setBounds(320, 260, 80, 30);
        add(b4);


        b1.addActionListener(e -> addRecord());

        b2.addActionListener(e -> viewRecords());

        b3.addActionListener(e -> deleteRecord());

        b4.addActionListener(e -> clearFields());


        setVisible(true);
    }

    void addRecord() {

        String sql =
                "INSERT INTO BOOK_ISSUE " +
                "(BOOK_ID, STUDENT_NAME, ISSUE_DATE, RETURN_DATE) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(t1.getText()));

            ps.setString( 2,t2.getText());

            ps.setDate(3,Date.valueOf(t3.getText()));

            ps.setDate(4,Date.valueOf(t4.getText()));

            ps.executeUpdate();


        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }


    void viewRecords() {

        String sql = "SELECT * FROM BOOK_ISSUE";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            String result = "";

            while (rs.next()) {

                result +="Book ID: " +rs.getInt("BOOK_ID") +"\n";

                result += "Student Name: " + rs.getString("STUDENT_NAME") + "\n";

                result +="Issue Date: " +rs.getDate("ISSUE_DATE") +"\n";

                result += "Return Date: " +rs.getDate("RETURN_DATE") +"\n";
            }

            JOptionPane.showMessageDialog( this, result);

        } catch (Exception e) {

            JOptionPane.showMessageDialog( this, e.getMessage());
        }
    }

    void deleteRecord() {

        String sql =
                "DELETE FROM BOOK_ISSUE WHERE BOOK_ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt( 1, Integer.parseInt(t1.getText()));

           

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }
    }
    void clearFields() {

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
    }


    public static void main(String[] args) {

        new App();
    }
}
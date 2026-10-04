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

        setTitle("Library Management System");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
        l1 = new JLabel("Book ID:");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        l2 = new JLabel("Book Name:");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        l3 = new JLabel("Author:");
        l3.setBounds(50, 150, 100, 30);
        add(l3);

        l4 = new JLabel("Price:");
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

        b1.addActionListener(e -> addBook());

        b2.addActionListener(e -> viewBooks());

        b3.addActionListener(e -> deleteBook());

        b4.addActionListener(e -> clearFields());

        setVisible(true);
    }

    void addBook() {

        String sql =
                "INSERT INTO LIBRARY " +
                "(BOOK_ID, BOOK_NAME, AUTHOR, PRICE) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(t1.getText()));
            ps.setString(2, t2.getText());
            ps.setString(3, t3.getText());
            ps.setInt(4, Integer.parseInt(t4.getText()));

            ps.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void viewBooks() {

        String sql = "SELECT * FROM LIBRARY";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            String result = "";

            while (rs.next()) {

                result += "Book ID: " + rs.getInt("BOOK_ID") + "\n";

                result +=  "Book Name: " + rs.getString("BOOK_NAME") + "\n";

                result +="Author: " + rs.getString("AUTHOR") + "\n";

                result += "Price: " + rs.getInt("PRICE") + "\n";

            }

            JOptionPane.showMessageDialog(this, result);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    
    void deleteBook() {

        String sql = "DELETE FROM LIBRARY WHERE BOOK_ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(t1.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this, "Book deleted successfully!");

            } else {

                JOptionPane.showMessageDialog(this,"Book not found!");
            }

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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment17A extends JFrame implements ActionListener {
    JTextField rollField, nameField, courseField, emailField;
    JButton submitButton, clearButton;

    Assignment17A() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Course:"));
        courseField = new JTextField();
        add(courseField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        submitButton = new JButton("Register");
        clearButton = new JButton("Clear");

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(submitButton);
        add(clearButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String roll = rollField.getText().trim();
            String name = nameField.getText().trim();
            String course = courseField.getText().trim();
            String email = emailField.getText().trim();

            if (roll.isEmpty() || name.isEmpty()
                    || course.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, "Please fill all fields"
                );
                return;
            }

            JOptionPane.showMessageDialog(
                this,
                "Registration Successful\n" +
                "Roll Number: " + roll + "\n" +
                "Name: " + name + "\n" +
                "Course: " + course + "\n" +
                "Email: " + email
            );
        } else if (e.getSource() == clearButton) {
            rollField.setText("");
            nameField.setText("");
            courseField.setText("");
            emailField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Assignment17A());
    }
}

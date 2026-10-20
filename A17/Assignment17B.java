
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment17B extends JFrame implements ActionListener {
    JTextField idField, nameField, departmentField, salaryField;
    JButton submitButton, clearButton;

    Assignment17B() {
        setTitle("Employee Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Employee ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Employee Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);

        add(new JLabel("Salary:"));
        salaryField = new JTextField();
        add(salaryField);

        submitButton = new JButton("Submit");
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
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String department = departmentField.getText().trim();

            try {
                double salary = Double.parseDouble(
                    salaryField.getText()
                );

                if (id.isEmpty() || name.isEmpty()
                        || department.isEmpty() || salary < 0) {
                    JOptionPane.showMessageDialog(
                        this, "Enter valid employee details"
                    );
                    return;
                }

                JOptionPane.showMessageDialog(
                    this,
                    "Employee Details\n" +
                    "ID: " + id + "\n" +
                    "Name: " + name + "\n" +
                    "Department: " + department + "\n" +
                    "Salary: " + salary
                );
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this, "Enter a valid salary"
                );
            }
        } else if (e.getSource() == clearButton) {
            idField.setText("");
            nameField.setText("");
            departmentField.setText("");
            salaryField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Assignment17B());
    }
}

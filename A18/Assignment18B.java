
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment18B extends JFrame implements ActionListener {
    JTextField balanceField, amountField;
    JLabel resultLabel;
    JButton depositButton, withdrawButton;

    Assignment18B() {
        setTitle("Bank Balance Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Initial Balance:"));
        balanceField = new JTextField();
        add(balanceField);

        add(new JLabel("Transaction Amount:"));
        amountField = new JTextField();
        add(amountField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        add(depositButton);
        add(withdrawButton);

        resultLabel = new JLabel("Updated balance will appear here");
        add(resultLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double balance = Double.parseDouble(
                balanceField.getText()
            );
            double amount = Double.parseDouble(
                amountField.getText()
            );

            if (balance < 0 || amount <= 0) {
                resultLabel.setText("Enter valid amounts");
                return;
            }

            if (e.getSource() == depositButton) {
                balance += amount;
            } else {
                if (amount > balance) {
                    resultLabel.setText("Insufficient balance");
                    return;
                }

                balance -= amount;
            }

            balanceField.setText(String.valueOf(balance));
            resultLabel.setText("Updated Balance: " + balance);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Enter numeric values");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Assignment18B());
    }
}

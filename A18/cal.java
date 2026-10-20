import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cal {
    // Calculator state variables
    private static double firstNum = 0;
    private static String firstNumStr = "";
    private static String currentNumStr = "";
    private static String operator = "";
    private static boolean isCalculated = false;

    //format to long  output
    private static String formatNumber(double num) {
        if (num == (long) num) {
            return String.valueOf((long) num);
        }
        return String.valueOf(num);
    }

    // actual logic for cal
    private static double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            default: return b;
        }
    }

    // display operation
    private static void updateDisplay(JLabel display) {
        if (display.getText().equals("Error")) {
            return;
        }

        if (operator.isEmpty()) {
            // just one number
            display.setText(currentNumStr.isEmpty() ? "0" : currentNumStr);
        } else {
            // full operation
            if (currentNumStr.isEmpty()) {
                display.setText(firstNumStr + " " + operator + " ");
            } else {
                display.setText(firstNumStr + " " + operator + " " + currentNumStr);
            }
        }
    }

    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Calculator");

        // Display panel
        JLabel display = new JLabel("0", SwingConstants.RIGHT);
        display.setBounds(100, 100, 390, 80);
        display.setBackground(new Color(240, 240, 240));

        // Operations
        JButton addbut = new JButton("+");
        addbut.setBounds(400, 400, 90, 90);
        JButton subbut = new JButton("-");
        subbut.setBounds(400, 300, 90, 90);
        JButton prodbut = new JButton("*");
        prodbut.setBounds(400, 200, 90, 90);
        JButton divbut = new JButton("/");
        divbut.setBounds(400, 500, 90, 90);
        JButton enter = new JButton("=");
        enter.setBounds(300, 500, 90, 90);

        // Digits
        JButton b0 = new JButton("0");
        b0.setBounds(200, 500, 90, 90);
        JButton b1 = new JButton("1");
        b1.setBounds(100, 400, 90, 90);
        JButton b2 = new JButton("2");
        b2.setBounds(200, 400, 90, 90);
        JButton b3 = new JButton("3");
        b3.setBounds(300, 400, 90, 90);
        JButton b4 = new JButton("4");
        b4.setBounds(100, 300, 90, 90);
        JButton b5 = new JButton("5");
        b5.setBounds(200, 300, 90, 90);
        JButton b6 = new JButton("6");
        b6.setBounds(300, 300, 90, 90);
        JButton b7 = new JButton("7");
        b7.setBounds(100, 200, 90, 90);
        JButton b8 = new JButton("8");
        b8.setBounds(200, 200, 90, 90);
        JButton b9 = new JButton("9");
        b9.setBounds(300, 200, 90, 90);

        // AC
        JButton bac = new JButton("AC");
        bac.setBounds(100, 500, 90, 90);

        //format font, size set for buttons and display panel
        //buttons
        Font butfont = new Font("Arial", Font.PLAIN, 20);

        JButton[] buttons = {
        bac, addbut, subbut, prodbut, divbut,
        b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
        enter,
        };

        for(JButton a:buttons){
            a.setFont(butfont);
        }

        //display panel
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setOpaque(true);
        display.setForeground(Color.black);
        display.setBackground(Color.lightGray);
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        display.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(10, 30, 10, 20)
            )
        );
        
        

        // bac.setFont(new Font("Arial", Font.PLAIN, 20));
        // addbut.setFont(new Font("Arial", Font.PLAIN, 20));
        // subbut.setFont(new Font("Arial", Font.PLAIN, 20));
        // prodbut.setFont(new Font("Arial", Font.PLAIN, 20));
        // divbut.setFont(new Font("Arial", Font.PLAIN, 20));
        // b0.setFont(new Font("Arial", Font.PLAIN, 20));
        // b1.setFont(new Font("Arial", Font.PLAIN, 20));
        // b2.setFont(new Font("Arial", Font.PLAIN, 20));
        // b3.setFont(new Font("Arial", Font.PLAIN, 20));
        // b4.setFont(new Font("Arial", Font.PLAIN, 20));
        // b5.setFont(new Font("Arial", Font.PLAIN, 20));
        // b6.setFont(new Font("Arial", Font.PLAIN, 20));
        // b7.setFont(new Font("Arial", Font.PLAIN, 20));
        // b8.setFont(new Font("Arial", Font.PLAIN, 20));
        // b9.setFont(new Font("Arial", Font.PLAIN, 20));
        // enter.setFont(new Font("Arial", Font.PLAIN, 20));

        
        ActionListener digitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String digit = source.getText();

                // if = was pressed
                if (isCalculated) {
                    currentNumStr = "";
                    firstNumStr = "";
                    operator = "";
                    isCalculated = false;
                }

                if (display.getText().equals("Error")) {
                    currentNumStr = "";
                    firstNumStr = "";
                    operator = "";
                }

                if (currentNumStr.equals("0")) {
                    currentNumStr = digit;
                } else {
                    currentNumStr += digit;
                }

                updateDisplay(display);
            }
        };

        // Attach digit listener to all number buttons (0-9)
        JButton[] digitButtons = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
        for (JButton b : digitButtons) {
            b.addActionListener(digitListener);
        }

        // +, -, *, /
        ActionListener opListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String newOp = source.getText();

                if (display.getText().equals("Error")) {
                    return;
                }

                // operation after operation
                if (!operator.isEmpty() && !currentNumStr.isEmpty()) {
                    try {
                        double secondNum = Double.parseDouble(currentNumStr);
                        firstNum = calculate(firstNum, secondNum, operator);
                        firstNumStr = formatNumber(firstNum);
                        currentNumStr = "";
                        operator = newOp;
                        isCalculated = false;
                        updateDisplay(display);
                    } catch (ArithmeticException ex) {
                        display.setText("Error");
                        firstNum = 0;
                        firstNumStr = "";
                        currentNumStr = "";
                        operator = "";
                        isCalculated = true;
                    }
                } else if (!currentNumStr.isEmpty()) {
                    // First time an operator is hit after typing a number
                    firstNum = Double.parseDouble(currentNumStr);
                    firstNumStr = formatNumber(firstNum);
                    currentNumStr = "";
                    operator = newOp;
                    isCalculated = false;
                    updateDisplay(display);
                } else if (!firstNumStr.isEmpty()) {
                    // Switching operators before entering 2nd number
                    operator = newOp;
                    isCalculated = false;
                    updateDisplay(display);
                } else {
                    // Operator pressed when display was 0
                    firstNum = 0;
                    firstNumStr = "0";
                    operator = newOp;
                    isCalculated = false;
                    updateDisplay(display);
                }
            }
        };

        addbut.addActionListener(opListener);
        subbut.addActionListener(opListener);
        prodbut.addActionListener(opListener);
        divbut.addActionListener(opListener);

        // 3. =
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!operator.isEmpty() && !currentNumStr.isEmpty()) {
                    try {
                        double secondNum = Double.parseDouble(currentNumStr);
                        double result = calculate(firstNum, secondNum, operator);
                        String resultStr = formatNumber(result);
                        display.setText(resultStr);
                        
                        // Save result as first number for next operation
                        firstNum = result;
                        firstNumStr = resultStr;
                        currentNumStr = "";
                        operator = "";
                        isCalculated = true;
                    } catch (ArithmeticException ex) {
                        display.setText("Error");
                        firstNum = 0;
                        firstNumStr = "";
                        currentNumStr = "";
                        operator = "";
                        isCalculated = true;
                    }
                }
            }
        });

        // AC
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNum = 0;
                firstNumStr = "";
                currentNumStr = "";
                operator = "";
                isCalculated = false;
                display.setText("0");
            }
        });

        // Adding to frame
        frame.add(addbut);
        frame.add(subbut);
        frame.add(prodbut);
        frame.add(divbut);
        frame.add(b0);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(bac);
        frame.add(enter);
        frame.add(display);

        // Frame settings
        // frame.setTitle("Calc");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setSize(600, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    } 
}
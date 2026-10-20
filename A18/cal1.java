import javax.swing.*;
import java.awt.*;

public class cal1{
    public static void main(String[] args){
        //frame
        JFrame frame = new JFrame("Calculator");

        //operations
        JButton addbut =  new JButton("+");
        addbut.setBounds(400, 400, 100, 100);
        JButton subbut = new JButton("-");
        subbut.setBounds(400,300, 100, 100);
        JButton prodbut = new JButton("*");
        prodbut.setBounds(400,200, 100, 100);
        JButton divbut = new JButton("/");
        divbut.setBounds(400, 500, 100, 100);
        JButton enter = new JButton("=");
        enter.setBounds(300,500, 100, 100);

        //digits
        JButton b0 = new JButton("0");
        b0.setBounds(200,500, 100, 100);
        JButton b1 = new JButton("1");
        b1.setBounds(100,400, 100, 100);
        JButton b2 = new JButton("2");
        b2.setBounds(200,400, 100, 100);
        JButton b3 = new JButton("3");
        b3.setBounds(300,400, 100, 100);
        JButton b4 = new JButton("4");
        b4.setBounds(100,300, 100, 100);
        JButton b5 = new JButton("5");
        b5.setBounds(200,300, 100, 100);
        JButton b6 = new JButton("6");
        b6.setBounds(300,300, 100, 100);
        JButton b7 = new JButton("7");
        b7.setBounds(100,200, 100, 100);
        JButton b8 = new JButton("8");
        b8.setBounds(200,200, 100, 100);
        JButton b9 = new JButton("9");
        b9.setBounds(300,200, 100, 100);

        //clear
        JButton bac = new JButton("AC");
        bac.setBounds(100, 500, 100, 100);

        //display panel
        JLabel display = new JLabel("calculator");
        display.setBounds(100, 100, 400, 100);


        //adding button and stuff to frame
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
        
        //setting frame
        frame.setSize(600, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        

    }
}
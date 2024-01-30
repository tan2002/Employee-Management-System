package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame implements ActionListener {
    FirstPage(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1170,620);
        setLocation(50,50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,10,1200,50);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(3,3,1150,600);
        add(image);

        JButton click = new JButton("CLICK HERE TO CONTINUE");
        click.setBounds(415,400,300,70);
        click.setBackground(new Color(204,255,255));
        click.setForeground(Color.black);
        click.addActionListener(this);
        image.add(click);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new FirstPage();
    }
}

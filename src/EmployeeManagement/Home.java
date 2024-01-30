package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton view, add, update,remove;
    public Home(){
//        GradientPaint gp = new GradientPaint()
        setLayout(null);
        setSize(1170,620);
        setLocation(50,50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(3,3,1150,600);
        add(image);


        add = new JButton();
        add.setText("Add Employee");
        add.setBounds(700,30,175,35);
        add.setBackground(new Color(204,255,255));
        add.addActionListener(this);
        add.setForeground(Color.black);
        image.add(add);

        view = new JButton();
        view.setText("View Employee");
        view.setBounds(900,30,175,35);
        view.setBackground(new Color(204,255,255));
        view.setForeground(Color.black);
        view.addActionListener(this);
        image.add(view);

        update = new JButton();
        update.setText("Update Employee");
        update.setBounds(700,80,175,35);
        update.setBackground(new Color(204,255,255));
        update.setForeground(Color.black);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton();
        remove.setText("Remove Employee");
        remove.setBounds(900,80,175,35);
        remove.setBackground(new Color(204,255,255));
        remove.setForeground(Color.black);
        remove.addActionListener(this);
        image.add(remove);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new View();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new View();
        }
        else{
            setVisible(false);
            new Remove();
        }
    }

    public static void main(String[] args) {
        new Home();
    }


}

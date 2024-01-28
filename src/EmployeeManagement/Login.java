package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userField,passField;
    Login(){
        setSize(600,300);
        setLocation(200,100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(40,20,100,30);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150,20,150,30);
        add(userField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(40,70,100,30);
        add(passLabel);

        passField = new JTextField();
        passField.setBounds(150,70,150,30);
        add(passField);

        JButton login = new JButton();
        login.setText("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        //System.out.println("Image Path: " + ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username = userField.getText();
            String password = passField.getText();

            Connect c = new Connect();
            String query = "select * from login where username='"+username+"' and password ='"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Credential.");
                setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //C.close();
    }
    public static void main(String[] args) {
        new Login();
    }
}

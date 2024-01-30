package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove extends JFrame implements ActionListener {
   Choice empId;
   JButton delete,back;
    public Remove(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1170,620);
        setLocation(50,50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel empIdLabel = new JLabel("Employee ID");
        empIdLabel.setBounds(50,100,150,30);
        empIdLabel.setFont(new Font("San_serif",Font.PLAIN,20));
        add(empIdLabel);

        empId = new Choice();
        empId.setBounds(200,100,150,30);
        add(empId);

        try{
            Connect c = new Connect();
            String query = "Select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                empId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("san_serif",Font.PLAIN,20));
        add(nameLabel);

        JLabel labelName = new JLabel();
        labelName.setBounds(200,150,150,30);
        add(labelName);

        JLabel phoneLabel = new JLabel("Phone No. ");
        phoneLabel.setBounds(50,200,150,30);
        phoneLabel.setFont(new Font("san_serif",Font.PLAIN,20));
        add(phoneLabel);

        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(200,200,150,30);
        add(labelPhone);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50,250,150,30);
        emailLabel.setFont(new Font("san_serif",Font.PLAIN,20));
        add(emailLabel);

        JLabel labelEmail = new JLabel();
        labelEmail.setBounds(200,250,150,30);
        add(labelEmail);

        try{
            Connect c = new Connect();
            String query = "Select * from employee where empId = '"+empId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelName.setText(rs.getString("name"));
                labelPhone.setText(rs.getString("phone"));
                labelEmail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        empId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Connect c = new Connect();
                    String query = "Select * from employee where empId = '"+empId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelName.setText(rs.getString("name"));
                        labelPhone.setText(rs.getString("phone"));
                        labelEmail.setText(rs.getString("email"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(100,320,150,40);
        delete.addActionListener(this);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        add(delete);

        back = new JButton("Back");
        back.setBounds(300,320,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,3,700,500);
        add(image);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Connect c = new Connect();
                String query = "delete from employee where empId = '"+empId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details deleted successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new Remove();
    }
}

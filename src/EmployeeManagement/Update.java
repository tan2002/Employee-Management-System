package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update extends JFrame implements ActionListener {
    String empId;
    JTextField fnameField,salaryField,addressField,phoneField,emailField,designationField,educationField;
    JLabel empIdLabel;
    JButton add,back;
    public Update(String empId){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1170,620);
        setLocation(50,50);
        setVisible(true);
        this.empId = empId;

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(nameLabel);

        JLabel labelName = new JLabel();
        labelName.setBounds(200,150,150,30);
        add(labelName);


        JLabel FnameLabel = new JLabel("Father's Name");
        FnameLabel.setBounds(400,150,150,30);
        FnameLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(FnameLabel);

        fnameField = new JTextField();
        fnameField.setBounds(600,150,150,30);
        add(fnameField);

        JLabel doblabel = new JLabel("Data of Birth");
        doblabel.setBounds(50,200,150,30);
        doblabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(doblabel);

        JLabel labelDob = new JLabel();
        labelDob.setBounds(200,200,150,30);
        add(labelDob);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(400,200,150,30);
        salaryLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(600,200,150,30);
        add(salaryField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50,250,150,30);
        addressLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(200,250,150,30);
        add(addressField);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(400,250,150,30);
        phoneLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(600,250,150,30);
        add(phoneField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50,300,150,30);
        emailLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200,300,150,30);
        add(emailField);

        JLabel highEduLabel = new JLabel("Highest Education");
        highEduLabel.setBounds(400,300,150,30);
        highEduLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        add(highEduLabel);

        educationField = new JTextField();
        educationField.setBounds(600,300,150,30);
        add(educationField);

        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setBounds(50,350,150,30);
        designationLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(200,350,150,30);
        add(designationField);

        JLabel adharLabel = new JLabel("Aadhar Number");
        adharLabel.setBounds(400,350,150,30);
        adharLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(adharLabel);

        JLabel labelAdhar = new JLabel();
        labelAdhar.setBounds(600,350,150,30);
        add(labelAdhar);

        JLabel LabelEmpId = new JLabel("Employee ID");
        LabelEmpId.setBounds(50,400,150,30);
        LabelEmpId.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(LabelEmpId);

        empIdLabel = new JLabel("");
        empIdLabel.setBounds(200,400,150,30);
        empIdLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(empIdLabel);

        try{
            Connect c = new Connect();
            String query = "select * from employee where empId  = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelName.setText(rs.getString("name"));
                fnameField.setText(rs.getString("fname"));
                labelDob.setText(rs.getString("dob"));
                salaryField.setText(rs.getString("salary"));
                addressField.setText(rs.getString("address"));
                phoneField.setText(rs.getString("phone"));
                emailField.setText(rs.getString("email"));
                designationField.setText(rs.getString("designation"));
                educationField.setText(rs.getString("education"));
                labelAdhar.setText(rs.getString("adhar"));
                empIdLabel.setText(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        add = new JButton("Update");
        add.setBounds(250,500,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,500,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String fname = fnameField.getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String education = educationField.getText();
            String designation = designationField.getText();

            try{
                Connect c = new Connect();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation ='"+designation+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully.");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new Update("");
    }
}

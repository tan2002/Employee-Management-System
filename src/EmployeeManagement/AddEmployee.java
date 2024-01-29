package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameField, fnameField,addressField, phoneField, adharField, emailField, salaryField, designationField;
    JDateChooser dcdob;
    JComboBox cbEducation;
    JLabel empIdLabel;
    JButton add,back;
    Random ran = new Random();
    int num = ran.nextInt(99999);

    public AddEmployee(){
        setVisible(true);
        setSize(1170,620);
        setLocation(50,50);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(3,3,1150,600);
        add(image);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        image.add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,150,150,30);
        nameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200,150,150,30);
        image.add(nameField);

        JLabel FnameLabel = new JLabel("Father's Name");
        FnameLabel.setBounds(400,150,150,30);
        FnameLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        image.add(FnameLabel);

        fnameField = new JTextField();
        fnameField.setBounds(600,150,150,30);
        image.add(fnameField);

        JLabel doblabel = new JLabel("Data of Birth");
        doblabel.setBounds(50,200,150,30);
        doblabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(doblabel);

        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        image.add(dcdob);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(400,200,150,30);
        salaryLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(600,200,150,30);
        image.add(salaryField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50,250,150,30);
        addressLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(200,250,150,30);
        image.add(addressField);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(400,250,150,30);
        phoneLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(600,250,150,30);
        image.add(phoneField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50,300,150,30);
        emailLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200,300,150,30);
        image.add(emailField);

        JLabel highEduLabel = new JLabel("Highest Education");
        highEduLabel.setBounds(400,300,150,30);
        highEduLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        image.add(highEduLabel);

        String[] courses = {"B.Sc", "B.A", "B.Com", "B.Tech", "BBA", "BCA", "B.Arch", "B.Pharm", "B.Ed", "B.F.A", "B.Music", "B.S.W", "B.H.M", "B.Des", "B.Lib.Sc", "BPT", "B.Nursing", "B.RM", "B.F.Sc", "BAMS"};
        cbEducation = new JComboBox(courses);
        cbEducation.setBounds(600,300,150,30);
        cbEducation.setBackground(Color.WHITE);
        image.add(cbEducation);

        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setBounds(50,350,150,30);
        designationLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(200,350,150,30);
        image.add(designationField);

        JLabel adharLabel = new JLabel("Aadhar Number");
        adharLabel.setBounds(400,350,150,30);
        adharLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(adharLabel);

        adharField = new JTextField();
        adharField.setBounds(600,350,150,30);
        image.add(adharField);

        JLabel LabelEmpId = new JLabel("Employee ID");
        LabelEmpId.setBounds(50,400,150,30);
        LabelEmpId.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(LabelEmpId);

        empIdLabel = new JLabel(""+num);
        empIdLabel.setBounds(200,400,150,30);
        empIdLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        image.add(empIdLabel);

         add = new JButton("Add");
         add.setBounds(250,500,150,40);
         add.addActionListener(this);
         add.setBackground(Color.BLACK);
         add.setForeground(Color.WHITE);
         image.add(add);

         back = new JButton("Back");
         back.setBounds(450,500,150,40);
         back.addActionListener(this);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         image.add(back);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name = nameField.getText();
            String fname = fnameField.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String education = (String) cbEducation.getSelectedItem();
            String designation = designationField.getText();
            String adhar = adharField.getText();
            String empId = empIdLabel.getText();

            try{
                Connect c = new Connect();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+adhar+"', '"+empId+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
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
        new AddEmployee();
    }
}

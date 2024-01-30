package EmployeeManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View extends JFrame implements ActionListener {
    Choice employeeId;
    JTable table;
    JButton search, update, print, back;
    public View(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1170,620);
        setLocation(50,50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel searchEmpId = new JLabel("Search by Employee ID");
        searchEmpId.setBounds(50,25,200,20);
        searchEmpId.setFont(new Font("Serif",Font.PLAIN,18));
        add(searchEmpId);

        employeeId = new Choice();
        employeeId.setBounds(250,25,150,20);
        add(employeeId);

        try{
           Connect c = new Connect();
           ResultSet rs = c.s.executeQuery("Select * from employee");
           while(rs.next()){
               employeeId.add(rs.getString("empId"));
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50,100,1050,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(50,60,120,30);
        search.setBackground(new Color(204,255,255));
        search.addActionListener(this);
        search.setForeground(Color.BLACK);
        add(search);

        update = new JButton("Update");
        update.setBounds(200,60,120,30);
        update.setBackground(new Color(204,255,255));
        update.addActionListener(this);
        update.setForeground(Color.BLACK);
        add(update);

        print = new JButton("Print");
        print.setBounds(350,60,120,30);
        print.setBackground(new Color(204,255,255));
        print.addActionListener(this);
        print.setForeground(Color.BLACK);
        add(print);

        back = new JButton("Back");
        back.setBounds(500,60,120,30);
        back.setBackground(new Color(204,255,255));
        back.addActionListener(this);
        back.setForeground(Color.BLACK);
        add(back);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from employee where empId = '"+employeeId.getSelectedItem()+"'";
            try{
                Connect c  = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new Update(employeeId.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new View();
    }
}

package EmployeeManagement;
import java.sql.*;
public class Connect {
    Connection c;
    Statement s;

    public Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/empMgmt","root","Tanmay@2002");
            s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}

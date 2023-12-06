package BankManegmentSystem;

import java.sql.*;
public class connection {
    Connection c;
    Statement s;
    connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///bankmanegmentsystem","root","MrRobot@92");
            s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

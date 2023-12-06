package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginPage extends JFrame  implements ActionListener {

     JButton Login,Sign_up,Clear;
    TextField cardTextfield;
    JPasswordField pinPassfield;
    LoginPage(){

 // Setting the Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,480);
        this.setLocation(350,200);
        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setLayout(null);

 // Adding Icon to the frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.white);
        this.add(l1);

//Heading of the login page
        JLabel text=new JLabel("Welcome to the ATM ");
        text.setBounds(200,45,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        this.add(text);

        JLabel cardNo=new JLabel("CARD NO :");
        cardNo.setBounds(120,150,150,30);
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        this.add(cardNo);

        JLabel pin=new JLabel("PIN :");
        pin.setBounds(120,220,150,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        this.add(pin);

// Creating TextField
        cardTextfield=new TextField();
        cardTextfield.setBounds(300,150,250,30);
        cardTextfield.setFont(new Font("Arial",Font.BOLD,14));
        this.add(cardTextfield);

        pinPassfield=new JPasswordField();
        pinPassfield.setBounds(300,220,250,30);
        pinPassfield.setFont(new Font("Arial",Font.BOLD,18));
        this.add(pinPassfield);

// Creating Buttons
        Login=new JButton();
        Login.setText("Login");
        Login.setFocusable(false);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.setBounds(300,295,120,30);
        Login.addActionListener(this);
        this.add(Login);

        Clear=new JButton();
        Clear.setText("Clear");
        Clear.setFocusable(false);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);
        Clear.setBounds(430,295,120,30);
        Clear.addActionListener(this);
        this.add(Clear);

        Sign_up=new JButton();
        Sign_up.setText("Sign up");
        Sign_up.setFocusable(false);
        Sign_up.setBackground(Color.BLACK);
        Sign_up.setForeground(new Color(255, 151, 38));
        Sign_up.setBounds(300,340,250,30);
        Sign_up.addActionListener(this);
        this.add(Sign_up);

        this.setVisible(true);

    }


    public static void main(String[] args) {
        new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Login){

            connection conn=new connection();

            String cardNo=cardTextfield.getText();
            String pinNo=pinPassfield.getText();

            String query="select * from login where cardno= '"+cardNo+"'and pin='"+pinNo+"'";
            try{
              ResultSet rs= conn.s.executeQuery(query);
              if (rs.next()){
                  setVisible(false);
                  new transaction(pinNo).setVisible(true);
              }else {
                  JOptionPane.showMessageDialog(null,"Card Number or PIN is wrong");
              }

            }catch (Exception e1){
                System.out.println(e1);
            }


        } else if(e.getSource()==Clear){
            cardTextfield.setText("");
            pinPassfield.setText("");

        }else if(e.getSource()==Sign_up){
            this.setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
}

package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    private String pinNO;
    private JLabel heading,bankHistory;
    private int bankBalance;
    private JButton back;
    BalanceEnquiry(String pinno){
        // Initialize JFrame
        super("Transaction");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        this.pinNO=pinno;

        // Set background color
        getContentPane().setBackground(new Color(0, 0, 0));


        ImageIcon atmLogo = new ImageIcon(ClassLoader.getSystemResource("Icons/atmlogo.png"));
        Image scaledImage = atmLogo.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBounds(50, 30, 100, 100);
        add(logoLabel);

        heading = new JLabel("Welcome to our Bank");
        heading.setBounds(470, 70, 200, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 15));
        heading.setForeground(Color.white);
        add(heading);
       try {
           connection con =new connection();
            ResultSet rs = con.s.executeQuery("select * from bank where pin='" + pinNO + "' ");
            bankBalance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    bankBalance += Integer.parseInt(rs.getString("amount"));
                } else {
                    bankBalance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
           System.out.println(e);
       }

        bankHistory=new JLabel("Your Current Bank-Balance is : "+ bankBalance);
        bankHistory.setBounds(70, 200, 500, 40);
        bankHistory.setFont(new Font("Arial", Font.BOLD, 27));
        bankHistory.setForeground(Color.white);
        this.add(bankHistory);


        back =new JButton();
        back.setText("BACK");
        back.setFocusable(false);
        back.setBounds(400,460,200,50);
        back.addActionListener(this);
        this.add(back);

    }

    public static void main(String[] args) {
      new BalanceEnquiry("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
            new transaction(pinNO).setVisible(true);
        }
    }
}

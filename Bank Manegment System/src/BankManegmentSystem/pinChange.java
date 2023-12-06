package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

     private String pinNo;

     private JLabel heading,Pin,RePin;
     private JTextField pin,repin;
     private JButton submit,back;

    pinChange(String pinno){
        super("PIN Change");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        pinNo=pinno;
        // Set background color
        getContentPane().setBackground(new Color(0, 0, 0));

        // Create and add components
        initializeComponents(pinNo);
    }

    private void  initializeComponents(String pinNo){
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

        Pin=new JLabel("PIN :");
        Pin.setBounds(70, 200, 100, 40);
        Pin.setFont(new Font("Arial", Font.BOLD, 27));
        Pin.setForeground(Color.white);
        this.add(Pin);

        RePin=new JLabel("Re-Enter PIN :");
        RePin.setBounds(70, 300, 200, 40);
        RePin.setFont(new Font("Arial", Font.BOLD, 27));
        RePin.setForeground(Color.white);
        this.add(RePin);

        pin = new JTextField();
        pin.setBounds(300, 200, 300, 50);
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setEditable(true);
        add(pin);

        repin = new JTextField();
        repin.setBounds(300, 300, 300, 50);
        repin.setFont(new Font("Raleway", Font.BOLD, 18));
        repin.setEditable(true);
        add(repin);


         submit=createButton("Submit",400,460);
        back=createButton("Back",400,520);
    }

    private JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 200, 50);
        button.setFont(new Font("Raleway", Font.BOLD, 16));
        button.addActionListener(this);
        button.setFocusable(false);
        add(button);
        return button;
    }


    public static void main(String[] args) {
//        new pinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==back){
        setVisible(false);
        new transaction(pinNo).setVisible(true);
    }else if(e.getSource()==submit){

//checking for empty and non-matching pin
        if(pin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Enter the pin");
        } else if(repin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Re-Enter the pin");
        } else if (!pin.getText().equals(repin.getText())){
            JOptionPane.showMessageDialog(null,"Pin and Re-Entered pin don't match");
        }


        try {
            connection con=new connection();
            String query1 = "update bank set pin='"+repin.getText()+"' where pin='"+pinNo+"'" ;
            String query2 = "update login set pin='"+repin.getText()+"' where pin='"+pinNo+"'" ;
            String query3 = "update signupthree set pin='"+repin.getText()+"' where pin='"+pinNo+"'" ;


            con.s.executeUpdate(query1);
            con.s.executeUpdate(query2);
            con.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
            setVisible(false);
            new transaction(pinNo).setVisible(true);


        }catch (Exception e1){
            System.out.println(e1);
        }

    }
    }
}

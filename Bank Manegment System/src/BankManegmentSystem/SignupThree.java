package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    private JLabel heading, account, card, cardno, cdetail, pin, pinno, pdetail, service;
    private JButton submit, cancel;
    private JRadioButton r1, r2, r3, r4;
    private JCheckBox c1, c2, c3, c4, c5, c6, c7;
    private String formno;

    public SignupThree(String formno) {
        this.formno = formno;

        // Initialize JFrame
        setTitle("Account Details");
        setSize(850, 820);
        setLocation(350, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set background color
        getContentPane().setBackground(Color.WHITE);

        // Create and add components
        initializeComponents();

        // Make frame visible
        setVisible(true);
    }

    private void initializeComponents() {
        heading = new JLabel("Page 3: Account Details");
        heading.setBounds(270, 80, 400, 30);
        heading.setFont(new Font("Osward", Font.BOLD, 24));
        add(heading);

        // Account Type
        account = new JLabel("Account Type :");
        account.setBounds(100, 160, 200, 40);
        account.setFont(new Font("Raleway", Font.BOLD, 22));
        add(account);

        r1 = createRadioButton("Saving Account", 100, 210);
        r2 = createRadioButton("Fixed Deposit Account", 350, 210);
        r3 = createRadioButton("Current Account", 100, 260);
        r4 = createRadioButton("Recurring Deposit Account", 350, 260);

        // Card Number
        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 320, 200, 30);
        add(card);

        cardno = new JLabel("XXXX-XXXX-XXXX-5954");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(310, 320, 300, 30);
        add(cardno);

        cdetail = new JLabel("Your 16 Digit Card Number");
        cdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cdetail.setBounds(100, 350, 300, 20);
        add(cdetail);

        // PIN
        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 400, 200, 30);
        add(pin);

        pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setBounds(310, 400, 100, 30);
        add(pinno);

        pdetail = new JLabel("Your 4 Digit Password");
        pdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetail.setBounds(100, 430, 300, 20);
        add(pdetail);

        // Service Required
        service = new JLabel("Service Required");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 470, 200, 30);
        add(service);

        c1 = createCheckBox("ATM Card", 100, 530);
        c2 = createCheckBox("Internet Banking", 350, 530);
        c3 = createCheckBox("Mobile Banking", 100, 570);
        c4 = createCheckBox("Email & SMS Alerts", 350, 570);
        c5 = createCheckBox("Cheque Book", 100, 610);
        c6 = createCheckBox("E-Statement", 350, 610);

        c7 = new JCheckBox("I hereby declare that the details above are correct to the best of my acknowledgment.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 665, 700, 20);
        c7.setBackground(Color.WHITE);
        c7.setFocusable(false);
        add(c7);

        // Buttons
        submit = createButton("Submit", Color.BLACK, new Color(255, 151, 38), 600, 710);
        cancel = createButton("Cancel", Color.WHITE, new Color(241, 91, 0), 450, 710);
    }

    private JRadioButton createRadioButton(String label, int x, int y) {
        JRadioButton radioButton = new JRadioButton(label);
        radioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        radioButton.setBounds(x, y, 200, 20);
        radioButton.setBackground(Color.WHITE);
        radioButton.setFocusable(false);
        add(radioButton);
        return radioButton;
    }

    private JCheckBox createCheckBox(String label, int x, int y) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox.setBounds(x, y, 200, 20);
        checkBox.setBackground(Color.WHITE);
        checkBox.setFocusable(false);
        add(checkBox);
        return checkBox;
    }

    private JButton createButton(String label, Color bgColor, Color fgColor, int x, int y) {
        JButton button = new JButton(label);
        button.setFocusable(false);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setBounds(x, y, 100, 30);
        button.addActionListener(this);
        add(button);
        return button;
    }

    public static void main(String[] args) {
        new SignupThree("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (e.getSource() == submit) {
                String saccountType = null;
                if (r1.isSelected()) {
                    saccountType = "Saving Account";
                } else if (r2.isSelected()) {
                    saccountType = "Fixed Deposit Account";
                } else if (r3.isSelected()) {
                    saccountType = "Current Account";
                } else if (r4.isSelected()) {
                    saccountType = "Recurring Deposit Account ";
                }
                Random random = new Random();
//          String cardNumber= ""+ Math.abs(random.nextLong()% 90000000L) + 5040936000000000L ;
                long randomSuffix = Math.abs(random.nextLong() % 90000000L);

                // Combine the random part and the provided constant part to form a 16-digit number
                String cardNumber = String.format("%016d", randomSuffix + 5040936000000000L);

//          String pinNumber =""+ Math.abs(random.nextInt()%9000)+1000;
                int randomSuffix2 = Math.abs(random.nextInt() % 900) + 100;

                // Combine the random part and the constant part to form a 4-digit PIN number
                String pinNumber = String.format("%04d", randomSuffix2 + 1000);

                String sServices = "";
                if (c1.isSelected()) {
                    sServices = sServices + " ATM Card";
                }
                if (c2.isSelected()) {
                    sServices = sServices + " Internet Banking";
                }
                if (c3.isSelected()) {
                    sServices = sServices + " Mobile Banking";
                }
                if (c4.isSelected()) {
                    sServices = sServices + " SMS & Email Alerts";
                }
                if (c5.isSelected()) {
                    sServices = sServices + " Cheque Book";
                }
                if (c6.isSelected()) {
                    sServices = sServices + " E-Statement";
                }

                try {
                    if (saccountType == null) {
                        JOptionPane.showMessageDialog(null, "Account Type is Required");
                    } else if (!c7.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Check the Acknowledgment Box");
                    } else {
                        connection conn = new connection();
                        String query1 = "insert into signupthree values('" + formno + "','" + saccountType + "','" + cardNumber + "','" + pinNumber + "', '" + sServices + "')";
                        String query2 = "insert into login values('" + formno + "','" + cardNumber + "','" + pinNumber + "')";
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Your Card number:"+cardNumber+" Your PIN:"+ pinNumber);
                        setVisible(false);
                        new LoginPage().setVisible(true);

                    }


                } catch (Exception e1) {
                    System.out.println(e1);
                }


            } else if (e.getSource() == cancel) {
                setVisible(false);
                new LoginPage().setVisible(true);
            }
        }
    }
}

package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {

    public JLabel heading;
    public JButton deposit, cashWithdraw, fastCash, minStatement, pinChange, balance, exit;

    public String pinNO;

    public transaction(String pinno) {
        // Initialize JFrame
        super("Transaction");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set background color
        getContentPane().setBackground(new Color(0, 0, 0));

        // Create and add components
        initializeComponents(pinno);

        // Make frame visible
        setVisible(true);

        pinNO=pinno;
    }

    private void initializeComponents(String pinno) {
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

        JTextField tf = new JTextField("     Please Select Your Transaction");
        tf.setBounds(150, 150, 450, 50);
        tf.setFont(new Font("Raleway", Font.BOLD, 25));
        Color backgroundColor = tf.getBackground();
        tf.setCaretColor(backgroundColor);
        tf.setEditable(false);
        add(tf);

        // Buttons
        deposit = createButton("Deposit", 150, 250);
        cashWithdraw = createButton("Cash Withdraw", 400, 250);
        fastCash = createButton("Fast Cash", 150, 320);
        minStatement = createButton("Minimum Statement", 400, 320);
        pinChange = createButton("PIN Change", 150, 390);
        balance = createButton("Balance", 400, 390);
        exit = createButton("Exit", 400, 460);
    }

    private JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 200, 50);
        button.setFont(new Font("Raleway", Font.BOLD, 16));
//        button.setForeground(Color.white);
        button.addActionListener(this);
//        button.setBackground(Color.darkGray);
        add(button);
        return button;
    }

    public static void main(String[] args) {
        new transaction("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource()==deposit) {
             setVisible(false);
            new Deposit(pinNO).setVisible(true);
        } else if (e.getSource()==cashWithdraw) {
             setVisible(false);
            new Withdraw(pinNO).setVisible(true);
        }else if (e.getSource()==fastCash) {
             setVisible(false);
            new fastcash(pinNO).setVisible(true);
        }else if (e.getSource()==pinChange) {
             setVisible(false);
            new pinChange(pinNO).setVisible(true);
        }else if (e.getSource()==balance) {
             setVisible(false);
            new BalanceEnquiry(pinNO).setVisible(true);
        }else if (e.getSource()==minStatement) {
            setVisible(false);
            new miniStatement(pinNO).setVisible(true);
        }
    }
}

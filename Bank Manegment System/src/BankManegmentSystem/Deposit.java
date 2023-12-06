package BankManegmentSystem;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    public JLabel heading,amount;
    public JButton deposit, back;

    public JTextField amountValue;

    public String pinNO;

    public Deposit(String pinno) {

        // Initialize JFrame
        super("Transaction");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        this.pinNO=pinno;

        // Set background color
        getContentPane().setBackground(new Color(0, 0, 0));

        // Create and add components
        initializeComponents(pinno);

        // Make frame visible
        setVisible(true);
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

        amount = new JLabel("Enter the amount you want to Deposit");
        amount.setBounds(150, 150, 300, 30);
        amount.setFont(new Font("Arial", Font.BOLD, 15));
        amount.setForeground(Color.white);
        add(amount);

        amountValue = new JTextField();
        amountValue.setBounds(150, 180, 450, 50);
        amountValue.setFont(new Font("Raleway", Font.BOLD, 18));
        amountValue.setEditable(true);
        add(amountValue);

        // Buttons
        deposit = createButton("Deposit", 400, 450);
        back = createButton("Back", 400, 510);
    }

    private JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 200, 50);
        button.setFont(new Font("Raleway", Font.BOLD, 18));
//        button.setForeground(Color.white);
        button.addActionListener(this);
//        button.setBackground(Color.darkGray);
        add(button);
        return button;
    }

    public static void main(String[] args) {
//        new Deposit("0000").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            System.exit(0);
        }else if(e.getSource()==deposit){
            String amount=amountValue.getText();
            Date date=new Date();

// checking for empty textField before submitting
            if(amountValue.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter the amount First");
            }else {
                try {
                    connection con = new connection();
                    String query = "insert into bank values('"+pinNO+"','"+date+"','deposit','"+amount+"') ";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Credited Successfully");
                    this.setVisible(false);
                    new transaction(pinNO).setVisible(true);
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        }
    }
}

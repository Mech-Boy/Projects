package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import  com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    Random ran;
    long random;
    JLabel heading1,heading2,name,FatherName,Dob,email,city,gender,marital,address,state,pincode;
    JTextField nameT,fnameT,addressT,cityT,stateT,pincodeT,emailT;
    JDateChooser dateChooser;


    JRadioButton male,female,married,unmarried,other;
    ButtonGroup genderGroup,maritalGroup;
    JButton next;

    SignupOne(){

              ran=new Random();
       random=Math.abs((ran.nextLong()%9000L)+1000L);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850,800);
        this.setLocation(350,10);
        this.setTitle("Detail Form");
        this.setLayout(null);
//Headings
        heading1=new JLabel("Application Form NO. : "+random);
        heading1.setBounds(200,10,450,35);
        heading1.setFont(new Font("Osward",Font.BOLD,30));
        this.add(heading1);

        heading2=new JLabel("Page 1: Personal Details ");
        heading2.setBounds(250,80,400,30);
        heading2.setFont(new Font("Osward",Font.BOLD,24));
        this.add(heading2);

//Remaining Text
        name=new JLabel("Name :");
        name.setBounds(100,140,200,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(name);
        nameT=new JTextField();
        nameT.setBounds(300,140,400,30);
        nameT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(nameT);

        FatherName=new JLabel("Father's Name :");
        FatherName.setBounds(100,190,200,30);
        FatherName.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(FatherName);
        fnameT=new JTextField();
        fnameT.setBounds(300,190,400,30);
        fnameT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(fnameT);

        Dob=new JLabel("Date of Birth :");
        Dob.setBounds(100,240,200,30);
        Dob.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(Dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        this.add(dateChooser);

        gender=new JLabel("Gender :");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(gender);
        male=new JRadioButton("Male");
        male.setBounds(300,290,150,30);
        this.add(male);
        female=new JRadioButton("Female");
        female.setBounds(460,290,150,30);
        this.add(female);
        genderGroup=new ButtonGroup();
        genderGroup.add(male);  genderGroup.add(female);


        email=new JLabel("Email :");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(email);
        emailT=new JTextField();
        emailT.setBounds(300,340,400,30);
        emailT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(emailT);

        marital=new JLabel("Marital Status :");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(marital);
        married=new JRadioButton("Married");
        married.setBounds(300,390,70,30);
        this.add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(460,390,100,30);
        this.add(unmarried);
        other=new JRadioButton("Other");
        other.setBounds(620,390,70,30);
        this.add(other);
        maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);


        address=new JLabel("Address :");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(address);
        addressT=new JTextField();
        addressT.setBounds(300,440,400,30);
        addressT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(addressT);

        city=new JLabel("City :");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(city);
        cityT=new JTextField();
        cityT.setBounds(300,490,400,30);
        cityT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(cityT);


        state=new JLabel("State :");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(state);
        stateT=new JTextField();
        stateT.setBounds(300,540,400,30);
        stateT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(stateT);

        pincode=new JLabel("PIN Code :");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(pincode);
        pincodeT=new JTextField();
        pincodeT.setBounds(300,590,400,30);
        pincodeT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(pincodeT);


        // Adding Button
        next=new JButton();
        next.setText("Next");
        next.setFocusable(false);
        next.setBackground(Color.BLACK);
        next.setForeground(new Color(255, 151, 38));
        next.setBounds(550,680,150,30);
        next.addActionListener(this);
        this.add(next);


        this.setVisible(true);
    }

    public static void main(String[] args) {
//        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+ random;
        String name=nameT.getText();
        String fname=fnameT.getText();
        String dob= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if(male.isSelected()){
            gender="male";
        } else if (female.isSelected()){
            gender="Female";
        }

        String email=emailT.getText();

        String marital=null;
        if(married.isSelected()){
            marital="Married";
        } else if (unmarried.isSelected()) {
            marital="Un-married";
        } else if (other.isSelected()) {
            marital="Other";
        }

        String address=addressT.getText();
        String city=cityT.getText();
        String state=stateT.getText();
        String pincode=pincodeT.getText();

        try {

//Form Validation
            if (name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name is required !");
            } else if (fname.isEmpty()){
                JOptionPane.showMessageDialog(null,"Fathers Name is required !");
            } else if (email.isEmpty()){
                JOptionPane.showMessageDialog(null,"Email is required !");
            } else if (state.isEmpty()){
                JOptionPane.showMessageDialog(null,"State is required !");
            } else if (pincode.isEmpty()){
                JOptionPane.showMessageDialog(null,"Pin-code is required !");
            } else if (address.isEmpty()){
                JOptionPane.showMessageDialog(null,"Address is required !");
            }

            else {
                connection c=new connection();
                String query=
                        "insert into signup values('"+formno+"','"+name+"', '"+fname+"','"+dob+"','"+email+"','"+gender
            +"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";

                c.s.executeUpdate(query);
                this.setVisible(false);
               new SignupTwo(formno).setVisible(true);
            }


        }catch (Exception e1){
            System.out.println(e1);
        }
    }
}

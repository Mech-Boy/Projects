package BankManegmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JLabel heading1,heading2, religion, category, income, eduction, occupation,panNo, adharNO, seniorCitizen, existingAcc;
    JTextField panT,adharT;

    JComboBox religionBox, catagoryBox, incomeBox,educationBox,occupationBox;
    JRadioButton yesAcc, noAcc,yesCitizen,noCitizen;

    ButtonGroup accGroup,citizenGroup;
    JButton next;
    String formno;

    SignupTwo(String formno){

        this.formno=formno;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850,800);
        this.setLocation(350,10);
        this.setTitle("Detail Form");
        this.setLayout(null);
//Headings
        heading1=new JLabel("New Account Application Form ");
        heading1.setBounds(200,10,470,35);
        heading1.setFont(new Font("Osward",Font.BOLD,30));
        this.add(heading1);

        heading2=new JLabel("Page 2: Additional Details");
        heading2.setBounds(250,80,400,30);
        heading2.setFont(new Font("Osward",Font.BOLD,24));
        this.add(heading2);

//Remaining Text
        religion =new JLabel("region :");
        religion.setBounds(100,140,200,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(religion);
        String [] valRiligon={" Hindu ","Muslim","Sikh","Christian "};
        religionBox =new JComboBox( valRiligon);
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.white);
        this.add(religionBox);


        category =new JLabel("Category:");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(category);
        String [] valCatagory={" Open","EWS","SEBC","OBC","SC/ST ","Other"};
        catagoryBox =new JComboBox( valCatagory);
        catagoryBox.setBounds(300,190,400,30);
        catagoryBox.setBackground(Color.white);
        this.add(catagoryBox);


        income =new JLabel("Income :");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(income);
        String [] valincome={" Null","< 1,00,000 ","< 5,00,000","< 8,00,000","> 8,00,000"};
        incomeBox =new JComboBox( valincome);
        incomeBox.setBounds(300,240,400,30);
        incomeBox.setBackground(Color.white);
        this.add(incomeBox);


        eduction =new JLabel("Education :");
        eduction.setBounds(100,290,200,30);
        eduction.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(eduction);
        String [] valeducation={" Non-Graduate","Graduate ","Post-Graduate","Doctorate","Other"};
        educationBox=new JComboBox( valeducation);
        educationBox.setBounds(300,290,400,30);
        educationBox.setBackground(Color.white);
        this.add(educationBox);

        occupation =new JLabel("Occupation :");
        occupation.setBounds(100,340,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(occupation);
        String [] valOccupation={"Un-Employed","Employed ","Businessmen","Student","Other"};
        occupationBox=new JComboBox( valOccupation);
        occupationBox.setBounds(300,340,400,30);
        occupationBox.setBackground(Color.white);
        this.add(occupationBox);


        panNo=new JLabel("PAN No :");
        panNo.setBounds(100,390,200,30);
        panNo.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(panNo);
        panT =new JTextField();
        panT.setBounds(300,390,400,30);
        panT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(panT);


        adharNO =new JLabel("Adhar No :");
        adharNO.setBounds(100,440,200,30);
        adharNO.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(adharNO);
        adharT =new JTextField();
        adharT.setBounds(300,440,400,30);
        adharT.setFont(new Font("Raleway",Font.BOLD,15));
        this.add(adharT);



        seniorCitizen =new JLabel("Senior Citizen :");
        seniorCitizen.setBounds(100,490,200,30);
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(seniorCitizen);
        yesCitizen =new JRadioButton("Yes");
        yesCitizen.setBackground(Color.white);
        yesCitizen.setBounds(300,490,150,30);
        this.add(yesCitizen);
        noCitizen =new JRadioButton("NO");
        noCitizen.setBounds(460,490,150,30);
        noCitizen.setBackground(Color.white);
        this.add(noCitizen);
        citizenGroup =new ButtonGroup();
        citizenGroup.add(yesCitizen);  citizenGroup.add(noCitizen);

        existingAcc =new JLabel("Existing Account :");
        existingAcc.setBounds(100,540,200,30);
        existingAcc.setFont(new Font("Raleway",Font.BOLD,20));
        this.add(existingAcc);
        yesAcc =new JRadioButton("Yes");
        yesAcc.setBounds(300,540,150,30);
        yesAcc.setBackground(Color.white);
        this.add(yesAcc);
        noAcc =new JRadioButton("NO");
        noAcc.setBounds(460,540,150,30);
        noAcc.setBackground(Color.white);
        this.add(noAcc);
        accGroup =new ButtonGroup();
        accGroup.add(yesAcc);  accGroup.add(noAcc);




        // Adding Button
        next=new JButton();
        next.setText("Next");
        next.setFocusable(false);
        next.setBackground(Color.BLACK);
        next.setForeground(new Color(255, 151, 38));
        next.setBounds(550,680,150,30);
        next.addActionListener(this);
        this.add(next);

         getContentPane().setBackground(Color.white);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//Storing the values from input sources.
       String sformno=formno;
       String sreligion=(String) religionBox.getSelectedItem();
       String scatagory=(String) catagoryBox.getSelectedItem();
       String sincome=(String) incomeBox.getSelectedItem();
       String seducation=(String) educationBox.getSelectedItem();
       String soccupation=(String) occupationBox.getSelectedItem();
       String span=panT.getText();
       String sadhar=adharT.getText();

        String sciniorcityzan=null;
        if(yesCitizen.isSelected()){
            sciniorcityzan="yes";
        } else if (noCitizen.isSelected()){
            sciniorcityzan="no";
        }

        String  saccount=null;
        if(yesAcc.isSelected()){
            saccount="yes";
        } else if (noAcc.isSelected()){
            saccount="no";
        }


//Connection to database
        try {
                connection c=new connection();
                String query= "insert into signuptwo values('"+sformno+"','"+sreligion+"','"+scatagory+"', '"+sincome+
                        "','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar +"','"+sciniorcityzan+"','"+saccount+"')";
                c.s.executeUpdate(query);
                this.setVisible(false);
                new SignupThree(formno).setVisible(true);

        }catch (Exception e1){
            System.out.println(e1);
        }
    }
}

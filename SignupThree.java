import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1 ,r2 ,r3 ,r4;
    JCheckBox c1 ,c2 ,c3 ,c4 ,c5 ,c6,c7;
    JButton submit ,cancel;

    String formno;
    SignupThree(String formno){
        this.formno=formno;

        setLayout(null);

        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setBounds(280,40,400,40);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);

        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);


        r1=new JRadioButton("Saving Account");
        r1.setBounds(100,200,150,18);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,200,250,20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBounds(100,240,150,18);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,240,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);


        ButtonGroup buttongroup=new ButtonGroup();
        buttongroup.add(r1);
        buttongroup.add(r2);
        buttongroup.add(r3);
        buttongroup.add(r4);


        JLabel card=new JLabel("Card Number:");
        card.setBounds(100,300,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,20));
        add(card);
        JLabel carddetails=new JLabel("your 16 digit card number");
        carddetails.setBounds(100,318,200,30);
        carddetails.setFont(new Font("Raleway",Font.BOLD,8));
        add(carddetails);

        JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-9102");
        cardnumber.setBounds(300,300,400,30);
        cardnumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardnumber);


        JLabel pin=new JLabel("PIN:");
        pin.setBounds(100,350,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        add(pin);

        JLabel pindetails=new JLabel("your 4 digit PIN");
        pindetails.setBounds(100,364,200,30);
        pindetails.setFont(new Font("Raleway",Font.BOLD,8));
        add(pindetails);

        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setBounds(300,350,400,30);
        pinnumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinnumber);


        JLabel servicerequired=new JLabel("Services Required:");
        servicerequired.setFont(new Font("Raleway",Font.BOLD,20));
        servicerequired.setBounds(100,420,200,30);
        add(servicerequired);


        c1=new JCheckBox("ATM Card");
        c1.setBounds(100,480,200,30);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(350,480,200,30);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.white);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,530,200,30);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.white);
        add(c3);


        c4=new JCheckBox("EMAIL & SMS Alerts ");
        c4.setBounds(350,530,200,30);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.white);
        add(c4);


        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,580,200,30);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.white);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBounds(350,580,200,30);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.white);
        add(c6);


        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best");
        c7.setBounds(100,650,600,30);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.white);
        add(c7);


        submit=new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setBounds(500,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(100,720,100,30);
        cancel.addActionListener(this);
        add(cancel);













        getContentPane().setBackground(Color.white);




        setSize(750,820);
        setLocation(350,0);
        setVisible(true);

    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){

            String type=null;
            if(r1.isSelected()){
                type="Saving Account";
            } else if (r2.isSelected()) {
                type="";
            } else if (r3.isSelected()) {
                type="";
            } else if (r4.isSelected()) {
                type="";
            }

            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()%9000000L)+ 9102800000000000L);
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility="";
            if(c1.isSelected()){
                facility=facility+" ATM";
            } else if (c2.isSelected()) {
                facility=facility+" Internet Banking";
            } else if (c3.isSelected()) {
                facility=facility+" Mobile Banking";
            } else if (c4.isSelected()) {
                facility=facility+" EMAIL & SMS Alerts";
            } else if (c5.isSelected()) {
                facility=facility+" Cheque Book";
            } else if (c6.isSelected()) {
                facility=facility+" E-Statement";
            }

            try{
                if(type.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                conn c=new conn();
                String query="insert into signupThree values('"+formno+"','"+type+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query1="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"Account successfully created \n Card Number:"+cardnumber+"\n PIN:"+pinnumber);
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);


            }
            catch (Exception a){
                System.out.println(a);
            }


        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}

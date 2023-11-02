import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    String pinnumber;

 JButton deposit,ministatement,balanceenquiry,cashwithdraw,fastcash,exit,pinchange;
    Transaction(String pinnumber){
     this.pinnumber=pinnumber;

       setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        deposit.addActionListener(this);
        image.add(deposit);

        cashwithdraw=new JButton("Cash Withdrawl");
        cashwithdraw.setBounds(355,415,150,30);
        cashwithdraw.setBackground(Color.white);
        cashwithdraw.setForeground(Color.BLACK);
        cashwithdraw.setFont(new Font("Raleway",Font.BOLD,12));
        cashwithdraw.addActionListener(this);
        image.add(cashwithdraw);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("Raleway",Font.BOLD,12));
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Satement");
        ministatement.setBounds(355,450,150,30);
        ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.BLACK);
        ministatement.setFont(new Font("Raleway",Font.BOLD,12));
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("PIN Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD,12));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.setBackground(Color.white);
        balanceenquiry.setForeground(Color.BLACK);
        balanceenquiry.setFont(new Font("Raleway",Font.BOLD,12));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setBackground(Color.white);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway",Font.BOLD,12));
        exit.addActionListener(this);
        image.add(exit);






        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

     if(ae.getSource()==deposit)
     {
      setVisible(false);
      new Deposit(pinnumber).setVisible(true);
     }



     else if (ae.getSource()==cashwithdraw)
     {
      setVisible(false);
      new Withdrawl(pinnumber).setVisible(true);
     }



     else if (ae.getSource()==fastcash)
     {
      setVisible(false);
      new FastCash(pinnumber).setVisible(true);
     }


     else if (ae.getSource()==ministatement)
     {
      setVisible(true);
      new MiniStatement(pinnumber).setVisible(true);
      
     }
     else if (ae.getSource()==balanceenquiry)
     {

      setVisible(false);
      new BalanceEnquiry(pinnumber).setVisible(true);

     } else if (ae.getSource()==pinchange) {

      setVisible(false);
      new PinChange(pinnumber).setVisible(true);

     } else if (ae.getSource()==exit) {

       System.exit(0);

     }


    }



    public static void main(String[] args) {
        new Transaction("");
    }
}

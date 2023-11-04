import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back =new JButton("Back");
        back.setBounds(370,515,130,30);
        back.addActionListener(this);
        image.add(back);

        conn c=new conn();

        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");


            while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }

        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Current Account Balance is Rs "+balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.white);
        image.add(text);




        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public  void  actionPerformed(ActionEvent ae){

        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }



    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

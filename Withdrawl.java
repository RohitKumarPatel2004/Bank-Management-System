import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdraw ,back;
    JTextField amount;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170,280,400,20);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(170,320,300,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,455,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        image.add(back);








        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource()==withdraw){


            String withdrew=amount.getText();
            Date date=new Date();
            conn c1= new conn();
            int bal=0;
            try{
            ResultSet rs=c1.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");

            while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));

                }
                else {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }


                if(withdrew.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your amount");

                }else if(Integer.parseInt(withdrew)<=bal) {
                    conn c=new conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+withdrew+"')";
                    try {
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs"+withdrew+" Deposited Successfully");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);

                    }catch (Exception e) {

                        System.out.println("ram"+e);
                    }
                }else if (Integer.parseInt(withdrew)>=bal){

                    JOptionPane.showMessageDialog(null,"Insufficient Balance");

                }



            }
            catch (Exception e){
                System.out.println(e);
            }







        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}


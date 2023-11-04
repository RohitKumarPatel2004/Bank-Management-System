import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public  class PinChange extends JFrame implements ActionListener {

    JButton back,change;
    JTextField NtextField,RtextField;

    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text=new JLabel("Change Your PIN");
        text.setBounds(250,270,400,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        JLabel pintext=new JLabel("New PIN:");
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.white);
        image.add(pintext);

        JLabel rpintext=new JLabel("Re-Enter PIN:");
        rpintext.setBounds(165,360,180,25);
        rpintext.setFont(new Font("System",Font.BOLD,16));
        rpintext.setForeground(Color.white);
        image.add(rpintext);

        NtextField=new JTextField();
        NtextField.setBounds(330,320,180,25);
        NtextField.setFont(new Font("System",Font.BOLD,16));
        image.add(NtextField);

        RtextField=new JTextField();
        RtextField.setBounds(330,360,180,25);
        RtextField.setFont(new Font("System",Font.BOLD,16));
        image.add(RtextField);

        change=new JButton("Change");
        change.setBounds(355,458,150,30);
        change.setFont(new Font("Raleway",Font.BOLD,16));
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(355,490,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);




        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource()==change)
        {
            try
            {
                String npin=NtextField.getText();
                String rpin=RtextField.getText();

                if(npin=="")
                {
                    JOptionPane.showMessageDialog(null, "Enter your new PIN");
                }
                else if (rpin=="")
                {
                    JOptionPane.showMessageDialog(null,"Please Re-Enter your PIN");
                    
                }
                else if (npin.equals(rpin))
                {
                    conn c=new conn();
                    String query1="update bank set pinnumber ='"+rpin+"' where pinnumber ='"+pinnumber+"'";
                    String query2="update login set pinnumber ='"+rpin+"' where pinnumber ='"+pinnumber+"'";
                    String query3="update signupThree set pinnumber ='"+rpin+"' where pinnumber ='"+pinnumber+"'";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"PIN Changeed Successfully");


                    setVisible(false);
                    new Transaction(rpin).setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Entered PIN Does Match");
                    return;
                }
            }

            catch (Exception e){
                System.out.println(e);
            }
        }

       else if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        

    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
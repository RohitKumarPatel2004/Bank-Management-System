
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends  JFrame  implements ActionListener {
      JButton login , clear , signup;
      JTextField cardTextField;
      JPasswordField pinTextField;
    Login(){

        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD , 38));
        text.setBounds(200,40 ,400 ,40);
        add(text);

        JLabel Card=new JLabel("Card No:");
        Card.setFont(new Font("Raleway", Font.BOLD , 28));
        Card.setBounds(120 , 150 , 150 , 30);
        add(Card);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250 ,30);
        cardTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(cardTextField);

        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD , 28));
        pin.setBounds(120 , 220 , 150 ,30);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD , 14));
        add(pinTextField);


        login=new JButton("SIGN IN");
        login.setBounds(300,300 ,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(420,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


        signup=new JButton("SIGN UP");
        signup.setBounds(300,340,220,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);



        getContentPane().setBackground(Color.white);



        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }

        else if (ae.getSource()==login)
        {
            conn c=new conn();
            String cardnumber1=cardTextField.getText();
            String pinnumber=pinTextField.getText();

            String query1="select * from login where cardnumber='"+cardnumber1+"' and pinnumber=  '"+pinnumber+"'";

            try{
                ResultSet re=c.s.executeQuery(query1);
                if(re.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                }
                else{

                    JOptionPane.showMessageDialog(null,"Incorrect CardNumber or Pin");

                }

            }catch (Exception e){
                System.out.println(e);
            }

        }
        else if (ae.getSource()==signup) {

            setVisible(false);
            new SignupOne().setVisible(true);

        }
    }



    public static void main(String[] args) {
        new Login();

    }
}

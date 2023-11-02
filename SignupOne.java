import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

  long random;
  JTextField nameTextField ,fnameTextField, emailTextField,addressTextField,cityTextField ,stateTextField ,pincodeTextField;
  JRadioButton  maleradio ,femaleradio,married,unmarried,other;
  JButton next;

  JDateChooser dateChooser;

    SignupOne(){

      setLayout(null);

      Random ran=new Random();
      random=Math.abs((ran.nextLong() % 9000L)+1000L);
      JLabel formno=new JLabel("APPLICATION FORM NO. "+ random);
      formno.setFont((new Font("Raleway",Font.BOLD,38)));
      formno.setBounds(140,20,600,40);
      add(formno);


      JLabel personDetails =new JLabel("Page 1: Personal Details");
      personDetails.setBounds(290,80,400,30);
      personDetails.setFont((new Font("Raleway",Font.BOLD,20)));
      add(personDetails);

        JLabel name =new JLabel("Name:");
        name.setBounds(100,140,200,30);
        name.setFont((new Font("Raleway",Font.BOLD,20)));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont((new Font("Raleway",Font.BOLD,16)));
        add(nameTextField);


        JLabel fname =new JLabel("Father's Name:");
        fname.setBounds(100,190,200,30);
        fname.setFont((new Font("Raleway",Font.BOLD,20)));
        add(fname);

      fnameTextField=new JTextField();
      fnameTextField.setBounds(300,190,400,30);
      fnameTextField.setFont((new Font("Raleway",Font.BOLD,16)));
      add(fnameTextField);

      JLabel dob =new JLabel("Date of Birth:");
      dob.setBounds(100,240,200,30);
      dob.setFont((new Font("Raleway",Font.BOLD,20)));
      add(dob);

      dateChooser=new JDateChooser();
      dateChooser.setBounds(300,240,400,30);
      dateChooser.setForeground(Color.black);
      dateChooser.setFont((new Font("Raleway",Font.BOLD,15)));
      add(dateChooser);

      JLabel Gender =new JLabel("Gender:");
      Gender.setBounds(100,290,200,30);
      Gender.setFont((new Font("Raleway",Font.BOLD,20)));
      add(Gender);

      maleradio=new JRadioButton("Male");
      maleradio.setBounds(300,290,100,30);
      maleradio.setBackground(Color.white);
      add(maleradio);

      femaleradio=new JRadioButton("Female");
      femaleradio.setBounds(400,290,100,30);
      femaleradio.setBackground(Color.white);
      add(femaleradio);

      ButtonGroup gendergroup=new ButtonGroup();
      gendergroup.add(maleradio);
      gendergroup.add(femaleradio);



      JLabel email =new JLabel("Email Address:");
      email.setBounds(100,340,200,30);
      email.setFont((new Font("Raleway",Font.BOLD,20)));
      add(email);


      emailTextField=new JTextField();
      emailTextField.setBounds(300,340,400,30);
      emailTextField.setFont((new Font("Raleway",Font.BOLD,16)));
      add(emailTextField);

      JLabel Marital =new JLabel("Marital Status:");
      Marital.setBounds(100,390,200,30);
      Marital.setFont((new Font("Raleway",Font.BOLD,20)));
      add(Marital);

      married=new JRadioButton("Married");
      married.setBounds(300,390,100,30);
      married.setBackground(Color.white);
      add(married);

      unmarried=new JRadioButton("Unmarried");
      unmarried.setBounds(400,390,100,30);
      unmarried.setBackground(Color.white);
      add(unmarried);

      other=new JRadioButton("Other");
      other.setBounds(500,390,100,30);
      other.setBackground(Color.white);
      add(other);


      ButtonGroup gendergroup1=new ButtonGroup();
      gendergroup1.add(married);
      gendergroup1.add(unmarried);
      gendergroup1.add(other);


      JLabel address =new JLabel("Address:");
      address.setBounds(100,440,200,30);
      address.setFont((new Font("Raleway",Font.BOLD,20)));
      add(address);

      addressTextField=new JTextField();
      addressTextField.setBounds(300,440,400,30);
      addressTextField.setFont((new Font("Raleway",Font.BOLD,16)));
      add(addressTextField);



      JLabel city =new JLabel("City:");
      city.setBounds(100,490,200,30);
      city.setFont((new Font("Raleway",Font.BOLD,20)));
      add(city);

      cityTextField=new JTextField();
      cityTextField.setBounds(300,490,400,30);
      cityTextField.setFont((new Font("Raleway",Font.BOLD,16)));
      add(cityTextField);

      JLabel state =new JLabel("State:");
      state.setBounds(100,540,200,30);
      state.setFont((new Font("Raleway",Font.BOLD,20)));
      add(state);

      stateTextField=new JTextField();
      stateTextField.setBounds(300,540,400,30);
      stateTextField.setFont((new Font("Raleway",Font.BOLD,16)));
      add(stateTextField);

      JLabel pincode =new JLabel("Pin Code:");
      pincode.setBounds(100,590,200,30);
      pincode.setFont((new Font("Raleway",Font.BOLD,20)));
      add(pincode);

      pincodeTextField=new JTextField();
      pincodeTextField.setBounds(300,590,400,30);
      pincodeTextField.setFont((new Font("Raleway",Font.BOLD,16)));
      add(pincodeTextField);



      next=new JButton("Next");
      next.setBounds(600,670,100,30);
      next.setFont((new Font("Raleway",Font.BOLD,15)));
      next.setBackground(Color.black);
      next.setForeground(Color.white);
      next.addActionListener(this);
      add(next);









        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);



    }

    public  void actionPerformed(ActionEvent ae){
      String formno=""+random;
      String name=nameTextField.getText();
      String fname=fnameTextField.getText();
      String dob =  ((JTextField)  dateChooser.getDateEditor().getUiComponent()).getText();
      String gender=null;
      if(maleradio.isSelected()){
        gender="Male";
      }
      else{
        gender="Female";
      }
      String email=emailTextField.getText();
      String marital=null;
      if(married.isSelected()){
        marital="Married";
      }
      else if(unmarried.isSelected()){
        marital="Unmarried";
      }
      else{
        marital="Other";
      }

      String address=addressTextField.getText();
      String city=cityTextField.getText();
      String state=stateTextField.getText();
      String pin=pincodeTextField.getText();


      try{

        if(name.equals("")){
          JOptionPane.showMessageDialog(null,"Name is Required");
        }
        else {
          conn c=new conn();
          String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
          c.s.executeUpdate(query);

          setVisible(false);
          new SignupTwo(formno).setVisible(true);
        }


      }
      catch (Exception e){
        System.out.println(e);
      }

    }

    public static void main(String[] args) {
        new SignupOne();
    }

}

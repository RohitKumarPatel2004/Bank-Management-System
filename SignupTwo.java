import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener {

        JTextField  pannumberField, aadharnumberField;
        JRadioButton  seniorN ,seniorY,exisitingN,exisitingY;
        JButton next;

        JComboBox religionfield,categoryfield,incomefield,educationalfield,occupationfield;

       String formno;

        SignupTwo(String formno){
           this.formno=formno;

            setLayout(null);



            JLabel personDetails =new JLabel("Page 2: Additional Details");
            personDetails.setBounds(290,80,400,30);
            personDetails.setFont((new Font("Raleway",Font.BOLD,20)));
            add(personDetails);

            JLabel relision =new JLabel("Religion:");
            relision.setBounds(100,140,200,30);
            relision.setFont((new Font("Raleway",Font.BOLD,20)));
            add(relision);

            String religionvalue[]={"Hindu","Muslim","Shikh","Other"};
            religionfield=new JComboBox<>(religionvalue);
            religionfield.setBounds(300,140,400,30);
            religionfield.setBackground(Color.white);
            add(religionfield);


            JLabel category =new JLabel("Category:");
            category.setBounds(100,190,200,30);
            category.setFont((new Font("Raleway",Font.BOLD,20)));
            add(category);

            String categoryvalue[]={"General","OBC","ST","SC","Other"};
            categoryfield=new JComboBox<>(categoryvalue);
            categoryfield.setBounds(300,190,400,30);
            categoryfield.setBackground(Color.white);
            add(categoryfield);

            JLabel income =new JLabel("Income:");
            income.setBounds(100,240,200,30);
            income.setFont((new Font("Raleway",Font.BOLD,20)));
            add(income);


            String incomevalue[]={"null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
            incomefield=new JComboBox<>(incomevalue);
            incomefield.setBounds(300,240,400,30);
            incomefield.setBackground(Color.white);
            add(incomefield);

            JLabel educational =new JLabel("Educational:");
            educational.setBounds(100,290,200,30);
            educational.setFont((new Font("Raleway",Font.BOLD,20)));
            add(educational);


            String educationvalue[]={"Non-Graduation","Graduate","Post-Graduate","Doctrate","other"};
            educationalfield=new JComboBox<>(educationvalue);
            educationalfield.setBounds(300,290,400,30);
            educationalfield.setBackground(Color.white);
            add(educationalfield);



            JLabel occupation =new JLabel("Occupation:");
            occupation.setBounds(100,340,200,30);
            occupation.setFont((new Font("Raleway",Font.BOLD,20)));
            add(occupation);

            String occupationvalue[]={"Salaried","Self-employed","Bussiness","Student","Retired","other"};
            occupationfield=new JComboBox<>(occupationvalue);
            occupationfield.setBounds(300,340,400,30);
            occupationfield.setBackground(Color.white);
            add(occupationfield);


            JLabel seniorCitizen =new JLabel("Senior Citizen:");
            seniorCitizen.setBounds(100,390,200,30);
            seniorCitizen.setFont((new Font("Raleway",Font.BOLD,20)));
            add(seniorCitizen);

            seniorY=new JRadioButton("Yes");
            seniorY.setBounds(300,390,100,30);
            seniorY.setBackground(Color.white);
            add(seniorY);

            seniorN=new JRadioButton("No");
            seniorN.setBounds(400,390,100,30);
            seniorN.setBackground(Color.white);
            add(seniorN);


            ButtonGroup gendergroup1=new ButtonGroup();
            gendergroup1.add(seniorN);
            gendergroup1.add(seniorY);



            JLabel pannumber =new JLabel("PAN Number:");
            pannumber.setBounds(100,440,200,30);
            pannumber.setFont((new Font("Raleway",Font.BOLD,20)));
            add(pannumber);

            pannumberField=new JTextField();
            pannumberField.setBounds(300,440,400,30);
            pannumberField.setFont((new Font("Raleway",Font.BOLD,16)));
            add(pannumberField);



            JLabel aadharnumber =new JLabel("Aadhar Number:");
            aadharnumber.setBounds(100,490,200,30);
            aadharnumber.setFont((new Font("Raleway",Font.BOLD,20)));
            add(aadharnumber);

            aadharnumberField=new JTextField();
            aadharnumberField.setBounds(300,490,400,30);
            aadharnumberField.setFont((new Font("Raleway",Font.BOLD,16)));
            add(aadharnumberField);

            JLabel exaccount =new JLabel("Exisiting Account:");
            exaccount.setBounds(100,540,200,30);
            exaccount.setFont((new Font("Raleway",Font.BOLD,20)));
            add(exaccount);

            exisitingY=new JRadioButton("Yes");
            exisitingY.setBounds(300,540,100,30);
            exisitingY.setBackground(Color.white);
            add(exisitingY);

            exisitingN=new JRadioButton("No");
            exisitingN.setBounds(400,540,100,30);
            exisitingN.setBackground(Color.white);
            add(exisitingN);


            ButtonGroup gendergroup=new ButtonGroup();
            gendergroup.add(exisitingN);
            gendergroup.add(exisitingY);



            next=new JButton("Next");
            next.setBounds(600,640,100,30);
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
            String religion=(String) religionfield.getSelectedItem();
            String category=(String) categoryfield.getSelectedItem();
            String income=(String) incomefield.getSelectedItem();
            String education=(String) educationalfield.getSelectedItem();
            String occupation=(String) occupationfield.getSelectedItem();
            String seniorCitizen=null;
            if(seniorY.isSelected()){
                seniorCitizen="Yes";
            }
            else{
                seniorCitizen="No";
            }
            String pannumber=pannumberField.getText();
            String aadharnumber=aadharnumberField.getText();
            String exaccount=null;
            if(exisitingY.isSelected()){
                exaccount="Yes";
            }
            else{
                exaccount="No";
            }



            try{

                if(income.equals("")){
                    JOptionPane.showMessageDialog(null,"income is Required");
                }
                else {
                    conn c=new conn();
                    String query="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+seniorCitizen+"','"+pannumber+"','"+aadharnumber+"','"+exaccount+"')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                }


            }
            catch (Exception e){
                System.out.println(e);
            }

        }

        public static void main(String[] args) {
            new SignupTwo("");
        }

    }




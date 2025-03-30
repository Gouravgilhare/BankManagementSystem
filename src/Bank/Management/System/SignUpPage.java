package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.lang.Math;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpPage extends JFrame implements ActionListener {

    JLabel formno, personalDetails, name, dob, gen,fname,mStatus, email, add , pincode,city,state;
    Long random;
    JDateChooser dateChooser;
    JRadioButton male,female, unmarried,married, other;
    JTextField  nameTextField, fnameTextField, emailTextField, addTextField , pincodeTextField,cityTextField,stateTextField;
    JButton next;

   public SignUpPage(){

        getContentPane().setBackground(Color.WHITE);
        setTitle("SIGN UP FORM");
        setLayout(null);

        //fORM nUMBER
        Random ran = new Random();
        random = Math.abs((ran.nextLong()% 9000L)+1000L);
        formno = new JLabel("APPLICATION FORM NO : " + random);
        formno.setFont(new Font("SEGOI UI", Font.BOLD,38));
        formno.setBounds(125,20,600,30);
        add(formno);


        //personalDetails
        personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
        personalDetails.setBounds(285, 80,280, 30);
        add(personalDetails);

        //name :
        name = new JLabel("Name: ");
        name.setBounds(50,130,200,30);
        name.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(name);

        //NAMETEXTFIELD
        nameTextField = new JTextField();
        nameTextField.setBounds(300,130,400,30);
        nameTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(nameTextField);

        //fname
        fname = new JLabel ("Father's Name: ");
        fname.setBounds(50,180,200,30);
        fname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(fname);

        //fNAMETEXTFIELD
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,180,400,30);
        fnameTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(fnameTextField);

        //dob
        dob = new JLabel("Date of Birth: ");
        dob.setBounds(50,230,200,30);
        dob.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(dob);

        //calender
        dateChooser= new JDateChooser();
        dateChooser.setBounds(300,230,400,30);
        dateChooser.setFont(new Font("Verdana", Font.PLAIN, 18));
//        dateChooser.setColor();
        add(dateChooser);

        //gender
        gen = new JLabel("Gender: ");
        gen.setBounds(50,280,200,30);
        gen.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(gen);


        //Male radioButtton
        male= new JRadioButton("Male");
        male.setBounds(300, 280,100,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(male);

        //feMale radioButtton
        female= new JRadioButton("Female");
        female.setBounds(420, 280,100,30);
        female.setFont(new Font("Verdana", Font.PLAIN, 18));
        female.setBackground(Color.WHITE);
        add(female);

        //Creating Group of buttons
        ButtonGroup buttonGroup= new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        //email
        email = new JLabel("Email: ");
        email.setBounds(50,330,200,30);
        email.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(email);

        //EMAILTEXTFIELD
        emailTextField = new JTextField();
        emailTextField.setBounds(300,330,400,30);
        emailTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(emailTextField);

        //Marital status
        mStatus = new JLabel("Marital Status ");
        mStatus.setBounds(50,380,200,30);
        mStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(mStatus);

        //Married radioButtton
        married= new JRadioButton("Married");
        married.setBounds(300, 380,100,30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(married);

        //unmarried radioButtton
        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(420, 380,125,30);
        unmarried.setFont(new Font("Verdana", Font.PLAIN, 18));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        //other button
        other= new JRadioButton("Other");
        other.setBounds(580, 380,100,30);
        other.setFont(new Font("Verdana", Font.PLAIN, 18));
        other.setBackground(Color.WHITE);
        add(other);

        //Creating Group of buttons
        ButtonGroup buttonGroup2= new ButtonGroup();
        buttonGroup2.add(married);
        buttonGroup2.add(unmarried);
        buttonGroup2.add(other);

        //Address
        add = new JLabel("Address: ");
        add.setBounds(50,430,200,30);
        add.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(add);

        //ADDTEXTFIELD
        addTextField = new JTextField();
        addTextField.setBounds(300,430,400,30);
        addTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(addTextField);

        //CITY
        city = new JLabel("City: ");
        city.setBounds(50,480,200,30);
        city.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(city);

        //cityTEXTFIELD
        cityTextField = new JTextField();
        cityTextField.setBounds(300,480,400,30);
        cityTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(cityTextField);

        //state
        state = new JLabel("State: ");
        state.setBounds(50,530,200,30);
        state.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(state);

        //StateTEXTFIELD
        stateTextField = new JTextField();
        stateTextField.setBounds(300,530,400,30);
        stateTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(stateTextField);

        //pincode
        pincode = new JLabel("Pincode: ");
        pincode.setBounds(50,580,200,30);
        pincode.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(pincode);

        //pincodeTEXTFIELD
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,580,400,30);
        pincodeTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(pincodeTextField);

        //Next BUtton
        next= new JButton("Next");
        next.setBounds(600,630,100,40);
        next.setFont(new Font("VERDANA", Font.BOLD, 22));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }


    public void actionPerformed(ActionEvent e){
        String formno = ""+ random;
        String name = nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //.getDateEditor : -
        String gen = null;
        if( male.isSelected()){
            gen = "Male";
        }else if(female.isSelected()){
            gen = "Female";
        }
        String email = emailTextField.getText();
        String mStatus= null;
        if(married.isSelected()){
            mStatus = "Married";
        }else if(unmarried.isSelected()){
            mStatus = "Unmarried";
        }else{
            mStatus = "Other";
        }

        String address = addTextField.getText();
        String city = cityTextField.getText();
        String state= stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try{
            if(dob.equals("") || name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required & Date of Birth is Compulsory");
            }
            else{
                conn c= new conn();

                String query = "INSERT INTO customer(formno,name,fname,dob,gen,email,mStatus,address,city,state,pincode) VALUES(?, ? ,? ,? ,?, ?,?,?,?,?,?)";
                PreparedStatement pstmt = c.getConnection().prepareStatement(query);

//                c.s.executeUpdate(query);
                pstmt.setString(1,formno);
                pstmt.setString(2,name);
                pstmt.setString(3,fname);
                pstmt.setString(4,dob);
                pstmt.setString(5,gen);
                pstmt.setString(6,email);
                pstmt.setString(7,mStatus);
                pstmt.setString(8,address);
                pstmt.setString(9,city);
                pstmt.setString(10,state);
                pstmt.setString(11,pincode);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("No rows inserted. Check query and data.");
                }

                // Commit and close connection

                pstmt.close();
                setVisible(false);
                new SignUpPage2(formno).setVisible(true);
            }
        }catch (Exception ae){
            System.out.println(ae);
        }
    }

    public static void main(String [] args){
        new SignUpPage();
    }
}


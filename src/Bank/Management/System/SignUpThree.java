package Bank.Management.System;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JCheckBox atm,mBanking,Esms,Estatement,iBanking,cheque;
    JRadioButton save, fix, recurring, current;
    JButton submit,cancel;
    String formno;
    JCheckBox confirm;
    SignUpThree(String formno){
        this.formno = formno;
        setTitle("Account Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Heading: Account Details
        JLabel heading = new JLabel("Page 3 : ACCOUNT DETAILS");
        heading.setBounds(200,80,400,30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setBackground(Color.WHITE);
        add(heading);

        //1 : Account Type
        JLabel acctype = new JLabel("Account Type: ");
        acctype.setBounds(100,180,200,30);
        acctype.setFont(new Font("Tahoma",Font.BOLD,22));
        acctype.setBackground(Color.WHITE);
        add(acctype);

        //Acc Options : saving Account
        save = new JRadioButton("Saving Account");
        save.setBounds(100 , 210,250,30);
        save.setFont(new Font("Verdana",Font.PLAIN,18));
        save.setBackground(Color.WHITE);
        add(save);

        //Acc Options: Fixed Deposit Account
        fix = new JRadioButton("Fixed Deposit Account");
        fix.setBounds(400 , 210,250,30);
        fix.setFont(new Font("Verdana",Font.PLAIN,18));
        fix.setBackground(Color.WHITE);
        add(fix);

        //Acc Option : Current Account
        current = new JRadioButton("Current Account");
        current.setBounds(100 , 240,250,30);
        current.setFont(new Font("Verdana",Font.PLAIN,18));
        current.setBackground(Color.WHITE);
        add(current);

        //Acc Option : recurring Account
        recurring = new JRadioButton("Recurring Account");
        recurring.setBounds(400 , 240,250,30);
        recurring.setFont(new Font("Verdana",Font.PLAIN,18));
        recurring.setBackground(Color.WHITE);
        add(recurring);

        ButtonGroup acctype1= new ButtonGroup();
        acctype1.add(recurring);
        acctype1.add(current);
        acctype1.add(fix);
        acctype1.add(save);


        //CardNumber Label
        JLabel cardNumberLabel = new JLabel("Card Number : ");
        cardNumberLabel.setBounds(100,310,200,30);
        cardNumberLabel.setFont(new Font("Tahoma",Font.BOLD,22));
        cardNumberLabel.setBackground(Color.WHITE);
        add(cardNumberLabel);


        //CardNumberhelpertext
        JLabel cardNumberhelper = new JLabel("(Your 16 digit card number)");
        cardNumberhelper.setBounds(100, 330, 250, 30);
        cardNumberhelper.setFont(new Font("Verdana", Font.PLAIN, 12));
        cardNumberhelper.setBackground(Color.WHITE);
        add(cardNumberhelper);

        //CardNumber

        JLabel cardNumber = new JLabel("XXXX-XXXX-XXX-XXXX");
        cardNumber.setBounds(400,310,500,30);
        cardNumber.setFont(new Font("verdana",Font.BOLD,22));
        cardNumber.setBackground(Color.WHITE);
        add(cardNumber);

        // Pin Label
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(100,370,200,30);
        pinLabel.setFont(new Font("Tahoma",Font.BOLD,22));
        pinLabel.setBackground(Color.WHITE);
        add(pinLabel);

        //pin
        JLabel pin = new JLabel("XXXX");
        pin.setBounds(400,370,500,30);
        pin.setFont(new Font("verdana",Font.BOLD,22));
        pin.setBackground(Color.WHITE);
        add(pin);

        //pinHelper
        JLabel pinhelper = new JLabel("(Your 4 digit password)");
        pinhelper.setBounds(100, 390, 250, 30);
        pinhelper.setFont(new Font("Verdana", Font.PLAIN, 12));
        pinhelper.setBackground(Color.WHITE);
        add(pinhelper);

        //Services Required
        JLabel service = new JLabel("Services Required: ");
        service.setBounds(100, 450,300,30);
        service.setFont(new Font("Tahoma", Font.BOLD,22));
        service.setBackground(Color.WHITE);
        add(service);

        //Service options : ATM card
        atm = new JCheckBox(" ATM Card");
        atm.setBounds(100, 480, 250, 30);
        atm.setFont(new Font("Verdana", Font.PLAIN, 16));
        atm.setBackground(Color.WHITE);
        add(atm);

        //Service options : Mobile Banking
        mBanking = new JCheckBox(" Mobile Banking");
        mBanking.setBounds(400, 480, 250, 30);
        mBanking.setFont(new Font("Verdana", Font.PLAIN, 16));
        mBanking.setBackground(Color.WHITE);
        add(mBanking);

        //Service options : INternet Banking
        iBanking = new JCheckBox(" Internet Banking");
        iBanking.setBounds(100, 520, 250, 30);
        iBanking.setFont(new Font("Verdana", Font.PLAIN, 16));
        iBanking.setBackground(Color.WHITE);
        add(iBanking);

        //Service options : email and Sms
        Esms = new JCheckBox(" Email & SMS");
        Esms.setBounds(400, 520, 250, 30);
        Esms.setFont(new Font("Verdana", Font.PLAIN, 16));
        Esms.setBackground(Color.WHITE);
        add(Esms);

        //Service options : email and Sms
        cheque = new JCheckBox(" Cheque Book");
        cheque.setBounds(100, 560, 250, 30);
        cheque.setFont(new Font("Verdana", Font.PLAIN, 16));
        cheque.setBackground(Color.WHITE);
        add(cheque);

        //Service options : email and Sms
        Estatement = new JCheckBox(" E-Statement");
        Estatement.setBounds(400, 560, 250, 30);
        Estatement.setFont(new Font("Verdana", Font.PLAIN, 16));
        Estatement.setBackground(Color.WHITE);
        add(Estatement);

        //confirmation
        confirm = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        confirm.setBackground(Color.WHITE);
        confirm.setBounds(50,630,750,30);
        confirm.setFont(new Font("Verdana", Font.PLAIN,16));
        add(confirm);

        //submit
        submit= new JButton("SUBMIT");
        submit.setBounds(450,680,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 22));
        submit.addActionListener(this);
        add(submit);

        //cancel
        cancel= new JButton("CANCEL");
        cancel.setBounds(200,680,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 22));
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    @Override
    public void  actionPerformed(ActionEvent e){

        if(e.getSource() == submit){
            String acctype = null;
            if(save.isSelected()) {
                acctype= "Saving Account";
            }else if( fix.isSelected()){
                acctype= "Fixed Deposit Account";
            }else if(current.isSelected()){
                acctype= "Current Account";
            } else if (recurring.isSelected()) {
                acctype= "Recurring Account";
            }

            Random random= new Random();
            String cardNumber = ""+ Math.abs( random.nextLong()%90000000L +781500000000L);
            String pinNumber = "" + Math.abs(random.nextLong()%9000+1000L);

            String requirements = "";
            if(atm.isSelected()){
                requirements += "ATM Card";
            } if(mBanking.isSelected()){
                requirements += "Mobile Banking";
            } if(iBanking.isSelected()){
                requirements += "Internet Banking";
            } if(cheque.isSelected()){
                requirements += "Cheque Book";
            }if(Esms.isSelected()){
                requirements += "Email & Sms Alerts";
            }if(Estatement.isSelected()){
                requirements += "E-Statement";
            }

            try{

                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else if(!confirm.isSelected()) {
                    JOptionPane.showMessageDialog(null,"Please tick the declaration");

                }else{
                        conn c= new conn();
                        String query = "Insert into  Signupthree VALUES('"+formno+"','"+acctype+"','"+cardNumber+"','"+pinNumber+"','"+requirements+"')";
                        c.s.executeUpdate(query);
                        String query1 = "Insert into  Atmdetails VALUES('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                        c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null,"CARD NUMBER : "+ cardNumber+ " \nPIN : "+pinNumber);
                        System.out.println("Data saved Successfuly");
                        setVisible(false);
                        new Login().setVisible(true);
                }
            }catch( Exception ae){
                System.out.println(ae);
            }

        }
        else if (e.getSource() == cancel) {
            setVisible(false);
            new SignUpPage2(formno);
        }
    }


    public static void main(String []args){
        new SignUpThree("");
    }
}



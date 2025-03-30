package Bank.Management.System;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

        JTextField amountTextField;
        JButton deposit,exit;
        String pin;
    public Deposit(String pin){
        this.pin = pin;
        setLayout(null);
        setUndecorated(true);

        //Image atm
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        //Deposit msg
        JLabel  depositMsg = new JLabel("Enter Amount You Want TO Deposit ");
        depositMsg.setBounds(200,300,300,30);
        depositMsg.setForeground(Color.white);
        depositMsg.setFont(new Font("Courier new", Font.BOLD, 14));
        image.add(depositMsg);

        // amountTextField
        amountTextField = new JTextField();
        amountTextField.setBounds(200,350,280,25);
        amountTextField.setBackground(Color.WHITE);
        image.add(amountTextField);

        //deposit button
        deposit= new JButton("Deposit");
        deposit.setBounds(365,485,150,30);
        deposit.setFont(new Font("courier new", Font.BOLD, 14));
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        //exit button
        exit= new JButton("Exit");
        exit.setBounds(365,520,150,30);
        exit.setFont(new Font("courier new", Font.BOLD, 14));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            try{
                String amount = amountTextField.getText();
                Date date = new Date();
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter Amount You Want to Deposit!!");
                }else{
                    int balance = 0;
                    conn c =  new conn();
                    ResultSet rs = c.s.executeQuery("select * from Transaction where pin = '"+ pin+"' Order by s_no DESC LIMIT 1;");
                        if(rs.next() == true ){
                            System.out.println("Inside 1");
                            if(rs.getString("balance") != "0" )
                            {

                                System.out.println("Inside 2");
                                balance = Integer.parseInt(rs.getString("balance"));
                                if(balance  == 0)
                                    balance =Integer.parseInt(amount);

                                balance  += Integer.parseInt(amount);
                            }
                        }else {
                                balance  = Integer.parseInt(amount);
                        }

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String query = "INSERT INTO Transaction (pin, type, amount, balance, date) VALUES ('"
                            + pin + "', 'Deposited', " + Integer.parseInt(amount) + ", " + balance + ", '" + sdf.format(date) + "')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" is Deposited Successfuly!!");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }catch( Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String args[]){


        new Deposit("");
    }
}

package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Withdrawl extends JFrame implements  ActionListener {

        JTextField amountTextField;
        JButton withdrawl,exit;
        String pin;
    public Withdrawl(String pin)
    {
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


        //withdrawl msg
        JLabel  withdrawlMsg = new JLabel("Enter Amount You Want TO Withdrawl ");
        withdrawlMsg.setBounds(190,300,310,30);
        withdrawlMsg.setForeground(Color.white);
        withdrawlMsg.setFont(new Font("Courier new", Font.BOLD, 14));
        image.add(withdrawlMsg);

        // amountTextField
        amountTextField = new JTextField();
        amountTextField.setBounds(200,350,280,25);
        amountTextField.setBackground(Color.WHITE);
        image.add(amountTextField);

        //withdrawl button
        withdrawl= new JButton("withdrawl");
        withdrawl.setBounds(365,485,150,30);
        withdrawl.setFont(new Font("courier new", Font.BOLD, 14));
        withdrawl.setForeground(Color.BLACK);
        withdrawl.addActionListener(this);
        add(withdrawl);

        //exit button
        exit= new JButton("Exit");
        exit.setBounds(365,520,150,30);
        exit.setFont(new Font("courier new", Font.BOLD, 14));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);


        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }

        //event handeling
        @Override
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawl){
            try{
                String amount = amountTextField.getText();
                Date date = new Date();
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter Amount You Want to withdrawl!!");
                }else{
                    conn c =  new conn();
                    int balance= 0;
                    ResultSet rs = c.s.executeQuery("select * from Transaction where pin = '"+ pin+"' Order by s_no DESC LIMIT 1;");
                    if(rs.next() == true){
                        if(rs.getString("balance") != "0" )
                        {
                            balance = Integer.parseInt(rs.getString("balance"));
                            balance  -= Integer.parseInt(amount);
                        }
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String query = "INSERT INTO Transaction (pin, type, amount, balance, date) VALUES ('"
                            + pin + "', 'Withdrawl', " + Integer.parseInt(amount) + ", " + balance + ", '" + sdf.format(date) + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" is withdrawled Successfuly!!");
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

      new Withdrawl("");
    }



}

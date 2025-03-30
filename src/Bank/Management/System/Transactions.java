package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl , fastcash, balanceEnq, miniStatement, pinChange, exit;
    private String pin;
    public Transactions(String pin){
        this.pin = pin;
        setLayout(null);
        setBackground(Color.BLUE);
        setUndecorated(true);

        //IMAGE OF ATM
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //TEXT
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(200,300,300,30);
        text.setFont(new Font("courier new", Font.BOLD, 15));
        text.setForeground(Color.white);
        image.add(text);

        //deposit button
        deposit= new JButton("Deposit");
        deposit.setBounds(155,415,150,30);
        deposit.setFont(new Font("courier new", Font.BOLD, 14));
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        //fastcash button
        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(155,450,150,30);
        fastcash.setFont(new Font("courier new", Font.BOLD, 14));
        fastcash.setForeground(Color.BLACK);
        fastcash.addActionListener(this);
        image.add(fastcash);

        //pinChange button
        pinChange= new JButton("Pin Change");
        pinChange.setBounds(155,485,150,30);
        pinChange.setFont(new Font("courier new", Font.BOLD, 14));
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        image.add(pinChange);

        //withdrawl button
        withdrawl= new JButton("Cash Withdrawl");
        withdrawl.setBounds(348,415,170,30);
        withdrawl.setFont(new Font("courier new", Font.BOLD, 16));
        withdrawl.setForeground(Color.BLACK);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        //balanceEnq button
        balanceEnq= new JButton("Balance Enquiry");
        balanceEnq.setBounds(348,450,170,30);
        balanceEnq.setFont(new Font("courier new", Font.BOLD, 14));
        balanceEnq.setForeground(Color.BLACK);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        //miniStatement button
        miniStatement= new JButton("Mini Statement");
        miniStatement.setBounds(348,485,170,30);
        miniStatement.setFont(new Font("courier new", Font.BOLD, 16));
        miniStatement.setForeground(Color.BLACK);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        //Exit button
        exit= new JButton("Exit");
        exit.setBounds(348,520,170,30);
        exit.setFont(new Font("courier new", Font.BOLD, 16));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if (ae.getSource() == balanceEnq){
            setVisible(false);
            new Balance(pin).setVisible(true);
        }else if (ae.getSource() == miniStatement){
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }

    }
    public static void main(String args[]){
        new Transactions("");
    }

}

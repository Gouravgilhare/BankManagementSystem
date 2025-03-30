package Bank.Management.System;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton rs100,rs1000 , rs500, rs2000, rs5000, rs10000, back;
    private String pin;
    public FastCash(String pin){
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
        JLabel text = new JLabel("Select Amount to Withdraw");
        text.setBounds(200,300,300,30);
        text.setFont(new Font("courier new", Font.BOLD, 16));
        text.setForeground(Color.white);
        image.add(text);

        //deposit button
        rs100= new JButton("Rs 100");
        rs100.setBounds(155,415,150,30);
        rs100.setFont(new Font("courier new", Font.BOLD, 16));
        rs100.setForeground(Color.BLACK);
        rs100.addActionListener(this);
        image.add(rs100);

        //fastcash button
        rs500= new JButton("Rs 500");
        rs500.setBounds(155,450,150,30);
        rs500.setFont(new Font("courier new", Font.BOLD, 16));
        rs500.setForeground(Color.BLACK);
        rs500.addActionListener(this);
        image.add(rs500);

        //pinChange button
        rs1000= new JButton("Rs 1000");
        rs1000.setBounds(155,485,150,30);
        rs1000.setFont(new Font("courier new", Font.BOLD, 16));
        rs1000.setForeground(Color.BLACK);
        rs1000.addActionListener(this);
        image.add(rs1000);

        //withdrawl button
        rs2000= new JButton("Rs 2000");
        rs2000.setBounds(348,415,170,30);
        rs2000.setFont(new Font("courier new", Font.BOLD, 16));
        rs2000.setForeground(Color.BLACK);
        rs2000.addActionListener(this);
        image.add(rs2000);

        //balanceEnq button
        rs5000= new JButton("Rs 5000");
        rs5000.setBounds(348,450,170,30);
        rs5000.setFont(new Font("courier new", Font.BOLD, 14));
        rs5000.setForeground(Color.BLACK);
        rs5000.addActionListener(this);
        image.add(rs5000);

        //miniStatement button
        rs10000= new JButton("Rs 10000");
        rs10000.setBounds(348,485,170,30);
        rs10000.setFont(new Font("courier new", Font.BOLD, 16));
        rs10000.setForeground(Color.BLACK);
        rs10000.addActionListener(this);
        image.add(rs10000);

        //back button
        back= new JButton("Back");
        back.setBounds(348,520,170,30);
        back.setFont(new Font("courier new", Font.BOLD, 16));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }else{

            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();

            try{
                int balance  = 0;
                ResultSet rs = c.s.executeQuery("select * from Transaction where pin = '"+ pin+"' Order by s_no DESC LIMIT 1;");
                if(rs.next() == true) if(rs.getString("balance") != "0" )
                {
                    balance = Integer.parseInt(rs.getString("balance"));
                    if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    balance  -= Integer.parseInt(amount);
                }



                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String query = "INSERT INTO Transaction (pin, type, amount, balance, date) VALUES ('"
                        + pin + "', 'Fastcash', " + Integer.parseInt(amount) + ", " + balance + ", '" + sdf.format(date) + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " + amount + "Withdrawl Successfully!!");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }catch (SQLException se){
                setVisible(false);
                System.out.println("Shayad Pin nhi mila table mai");

                System.out.println(se);
            }
        }

    }
    public static void main(String args[]){
        new FastCash("");
    }

}


package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Balance extends JFrame implements ActionListener {


    JButton exit;
    String pin;
    JLabel balanceLabel, image;
    public Balance(String pin)
    {
        this.pin = pin;
        setLayout(null);
        setUndecorated(true);

        //Image atm
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
         image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        //withdrawl msg
        JLabel  balanceMsg = new JLabel("Your Current Balance is ");
        balanceMsg.setBounds(190,300,310,30);
        balanceMsg.setForeground(Color.white);
        balanceMsg.setFont(new Font("Courier new", Font.BOLD, 18));
        image.add(balanceMsg);



        JLabel hname = new JLabel("");
        hname.setBounds(190,450,400,30);
        hname.setFont(new Font("Courier new", Font.BOLD, 14));
        hname.setForeground(Color.white);


        balanceLabel = new JLabel(" ");
        balanceLabel.setBounds(190,400,310,30);
        balanceLabel.setForeground(Color.white);
        balanceLabel.setFont(new Font("Courier new", Font.BOLD, 20));




        //exit button
        exit= new JButton("Exit");
        exit.setBounds(365,520,150,30);
        exit.setFont(new Font("courier new", Font.BOLD, 14));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);

        try{


            conn c =  new conn();
            int balance= 0;
            ResultSet rs = c.s.executeQuery("select * from Transaction where pin = '"+ pin+"' Order by s_no DESC LIMIT 1;");
            if(rs.next() == true){
                balance  = rs.getInt("balance");
            }
            String name = "Acount Holder : ";
            String query2 ="Select name from customer where formno = (select formno from atmdetails where PinNumber = '" + pin+"');";

            ResultSet rp = c.s.executeQuery(query2);
            if(rp.next())
            hname.setText(name +  rp.getString("name"));

            image.add(hname);
            balanceLabel.setText(String.valueOf(balance)  + " Rs");
            image.add(balanceLabel);

        }catch( Exception e){
            System.out.println(e);
        }

        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }

    //event handeling
    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }



    }

    public static void main(String args[]){

        new Balance("");
    }



}

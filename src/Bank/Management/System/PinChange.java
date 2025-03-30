package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PinChange extends JFrame implements  ActionListener {

    JTextField pinTextField;
    JButton PinChange,exit;
    String pin;
    public PinChange(String pin)
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


        //PinChange msg
        JLabel  PinChangeMsg = new JLabel("Enter New 4 digit Pin");
        PinChangeMsg.setBounds(190,300,310,30);
        PinChangeMsg.setForeground(Color.white);
        PinChangeMsg.setFont(new Font("Courier new", Font.BOLD, 20));
        image.add(PinChangeMsg);

        // pinTextField
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Courier new", Font.BOLD, 18));
        pinTextField.setBounds(200,350,280,30);
        pinTextField.setBackground(Color.WHITE);
        image.add(pinTextField);

        //PinChange button
        PinChange= new JButton("Change Pin");
        PinChange.setBounds(365,485,150,30);
        PinChange.setFont(new Font("courier new", Font.BOLD, 14));
        PinChange.setForeground(Color.BLACK);
        PinChange.addActionListener(this);
        image.add(PinChange);

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

    //event handeling
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == PinChange){
            try{
                    conn c = new conn();
                    String query = "UPDATE transaction SET pin = '"+pinTextField.getText()+"' WHERE pin = '"+pin+"';";
                String query2 = "UPDATE atmdetails SET pinNumber = '"+pinTextField.getText()+"' WHERE pinNumber = '"+pin+"';";
                String query3 = "UPDATE signupthree SET pinNumber = '"+pinTextField.getText()+"' WHERE pinNumber = '"+pin+"';";

                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null," PinChangeed Successfuly!!");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);

            }catch( Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String args[]){

        new PinChange("1206");
    }



}

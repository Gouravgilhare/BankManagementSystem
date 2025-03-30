package Bank.Management.System;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JLabel text, pinText, card;
    JTextField cardTextField, pinTextField;
    JButton signIn, clear,signUp;
    Login(){

        setTitle("AUTOMATED TELLER MACHINE ");
        setLayout(null);
        //LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        //Background
        getContentPane().setBackground(Color.WHITE);


        //WELCOME TEXT
         text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("SEGOI  UI",Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);

        //CARD NUMBER
        card = new JLabel("CARD NO: ");
        card.setFont(new Font("Tahoma",Font.BOLD, 22));
        card.setBounds(120,150,150,30);
        add(card);

        //Card number input field
        cardTextField = new JTextField("");
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Verdana", Font.PLAIN,15));
        add(cardTextField);

        //PIN NUMBER
        pinText = new JLabel("PIN: ");
        pinText.setFont(new Font("Tahoma",Font.BOLD, 22));
        pinText.setBounds(120,200,150,30);
        add(pinText);


        //PIN number input field
        pinTextField = new JTextField("");
        pinTextField.setBounds(300,200,250,30);
        pinTextField.setFont(new Font("Verdana", Font.PLAIN,15));
        add(pinTextField);

        //SignIN BUTTON
        signIn = new JButton("SIGN IN");
        signIn.setBounds(300,250,120,30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);

        //clear Button
        clear = new JButton("CLEAR");
        clear.setBounds(430,250,120,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        //Signup button
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,300,250,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);


        setSize( 800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear){
            pinTextField.setText(" ");
            cardTextField.setText(" ");
        }else if ( e.getSource() == signUp){
            setVisible(false);
            new SignUpPage().setVisible(true);
        }else if(e.getSource() == signIn){
            conn conn =new conn();
            String cardNumber = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = " Select * from atmdetails where CardNumber = '"+cardNumber+"' and pinnumber = '"+pin+"';";
            try{
               ResultSet rs=  conn.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid CardNumber or Pin");
                }
            }catch (Exception ae){
                System.out.println(ae);
            }
        }
    }
    public static void main(String [] args){
        new Login();
    }


}


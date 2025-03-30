package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MiniStatement extends JFrame implements  ActionListener {

    JButton exit;
    JLabel statementMsg,tableLabel;
    String pin;
    public MiniStatement(String pin)
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
        statementMsg = new JLabel("Mini Statement");
        statementMsg.setBounds(190,300,310,30);
        statementMsg.setForeground(Color.white);
        statementMsg.setFont(new Font("Courier new", Font.BOLD, 20));
        image.add(statementMsg);


        tableText(pin, image);



//      //exit button
        exit= new JButton("Exit");
        exit.setBounds(365,300,150,30);
        exit.setFont(new Font("courier new", Font.BOLD, 14));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);


        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }

    public void tableText(String Pin, JLabel image){


        tableLabel = new JLabel();
        tableLabel.setFont(new Font("Courier new", Font.BOLD, 10));
        tableLabel.setOpaque(false);
        tableLabel.setBackground(Color.black);
        tableLabel.setForeground(Color.white);
        tableLabel.setVerticalAlignment(SwingConstants.TOP);
        tableLabel.setBounds(160,330,350,300);


        try {

            conn c = new conn();
            String query = "SELECT date,type,amount,balance  FROM transaction  WHERE PIN = '"+pin+"';";
            ResultSet rs = c.s.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int column = metaData.getColumnCount();


            //header
            StringBuilder tableText = new StringBuilder("<html><pre>");
            tableText.append("--------------------------------------------------------<br>");
            tableText.append(String.format("| %-15s | %-10s | %-7s | %-7s |<br>","Date & Time","Type","Amount","Balance"));
            tableText.append("--------------------------------------------------------<br>");

            while(rs.next()){
                tableText.append(String.format("| %-15s | %-10s | %-7s | %-7s |<br>",rs.getString("date").substring(5,19),rs.getString("type"), rs.getString("amount"), rs.getString("balance")));
            }
            tableText.append("--------------------------------------------------------<br>");

            tableText.append("</pre></html>");

            tableLabel.setText(tableText.toString());

            rs.close();

        }catch( SQLException se){
            System.out.println("Error Fetching data : "+ se.getMessage());
        }

        JScrollPane sp = new JScrollPane(tableLabel);
        sp.setBounds(150,330,350,300);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setOpaque(false);
        sp.getViewport().setOpaque(false);

        image.setLayout(null);
        image.add(tableLabel);
        image.revalidate();
        image.repaint();
    }







//    event handeling
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){


            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String args[]){

        new MiniStatement("775");
    }



}

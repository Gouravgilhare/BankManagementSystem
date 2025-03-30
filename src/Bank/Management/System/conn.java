package Bank.Management.System;

import java.sql.*;


public class conn {
    Connection conn;
    Connection c;    //inbuilt class of java.sql
    public Statement s;

    public conn(){

        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","BankServer", "Bank@1234");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String [] args){
        new conn();

    }
    public Connection getConnection() {
        return c;
    }

}

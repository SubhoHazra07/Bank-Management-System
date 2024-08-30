package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinNumber;

    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Photos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("System",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        Conn conn=new Conn();
        int balance=0;
        try{
            ResultSet resultset=conn.s.executeQuery("select * from bank where pinnumber = '"+pinNumber+"'");
            while(resultset.next()){
                if(resultset.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultset.getString("amount"));
                }else{
                    balance-=Integer.parseInt(resultset.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Current Account Balance is Rs : "+balance+"/-");
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String[]args){
        new BalanceEnquiry("").setVisible(true);
    }
}

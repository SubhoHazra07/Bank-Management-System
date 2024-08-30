package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends  JFrame implements ActionListener{

    JButton hundred,twoHundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String pinNumber;

    FastCash(String pinNumber){

        this.pinNumber=pinNumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Photos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select Withdraw Amount");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        hundred=new JButton("Rs : 100");
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred=new JButton("Rs : 500");
        fiveHundred.setBounds(355,415,150,30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand=new JButton("Rs : 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand=new JButton("Rs : 2000");
        twoThousand.setBounds(355,450,150,30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand=new JButton("Rs : 5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand=new JButton("Rs : 10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(5);
            Conn conn=new Conn();
            try{
                ResultSet resultset=conn.s.executeQuery("select * from bank where pinnumber = '"+pinNumber+"'");
                int balance=0;
                while(resultset.next()){
                    if(resultset.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultset.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(resultset.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs : "+amount+"/- Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception e){
                System.err.println(e);
            }
        }
    }
    public static void main(String[]args){
        new FastCash("");
    }
}

package bank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    String formno;
    JRadioButton savingAccount,fdAccount,currentAccount,rdAccount;
    JCheckBox atmCard,internetBanking,mobileBanking,emailAlerts,checkBook,eStatement,declare;
    JButton submit,cancel;
    
    SignUpThree(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel l1=new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        savingAccount=new JRadioButton("Savings Account");
        savingAccount.setFont(new Font("Raleway",Font.BOLD,16));
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(100,180,250,20);
        add(savingAccount);

        fdAccount=new JRadioButton("Fixed Deposit Amount");
        fdAccount.setFont(new Font("Raleway",Font.BOLD,16));
        fdAccount.setBackground(Color.WHITE);
        fdAccount.setBounds(350,180,250,20);
        add(fdAccount);

        currentAccount=new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway",Font.BOLD,16));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100,220,250,20);
        add(currentAccount);

        rdAccount=new JRadioButton("Recurring  Deposit Account");
        rdAccount.setFont(new Font("Raleway",Font.BOLD,16));
        rdAccount.setBackground(Color.WHITE);
        rdAccount.setBounds(350,220,250,20);
        add(rdAccount);

        ButtonGroup groupAccount=new ButtonGroup();
        groupAccount.add(savingAccount);
        groupAccount.add(fdAccount);
        groupAccount.add(currentAccount);
        groupAccount.add(rdAccount);

        JLabel card=new JLabel("Card Number ");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel demo=new JLabel("Your 16-Digit Card Number");
        demo.setFont(new Font("Raleway",Font.BOLD,12));
        demo.setBounds(100,330,300,20);
        add(demo);

        JLabel pin=new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        JLabel demopin=new JLabel("Your 4-Digit PIN");
        demopin.setFont(new Font("Raleway",Font.BOLD,12));
        demopin.setBounds(100,400,300,20);
        add(demopin);

        JLabel services=new JLabel("Services Required : ");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,420,400,30);
        add(services);

        atmCard=new JCheckBox("ATM Card");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway",Font.BOLD,16));
        atmCard.setBounds(100,500,200,30);
        add(atmCard);

        internetBanking=new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway",Font.BOLD,16));
        internetBanking.setBounds(350,500,200,30);
        add(internetBanking);

        mobileBanking=new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway",Font.BOLD,16));
        mobileBanking.setBounds(100,550,200,30);
        add(mobileBanking);

        emailAlerts=new JCheckBox("Email and SMS Alerts");
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setFont(new Font("Raleway",Font.BOLD,16));
        emailAlerts.setBounds(350,550,200,30);
        add(emailAlerts);

        checkBook=new JCheckBox("Cheque Book");
        checkBook.setBackground(Color.WHITE);
        checkBook.setFont(new Font("Raleway",Font.BOLD,16));
        checkBook.setBounds(100,600,200,30);
        add(checkBook);

        eStatement=new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway",Font.BOLD,16));
        eStatement.setBounds(350,600,200,30);
        add(eStatement);

        declare=new JCheckBox("I here by declares that the above entered details are correct to the best of my knowledge");
        declare.setBackground(Color.WHITE);
        declare.setFont(new Font("Raleway",Font.BOLD,12));
        declare.setBounds(100,680,600,30);
        add(declare);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(savingAccount.isSelected()){
                accountType="Savings Account";
            }else if(fdAccount.isSelected()){
                accountType="Fixed Deposit Amount";
            }else if(currentAccount.isSelected()){
                accountType="Current Account";
            }else if(rdAccount.isSelected()){
                accountType="Recurring Deposit Amount";
            }

            Random random=new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            int pinInt=random.nextInt(9000)+1000;
            String pinNumber=String.valueOf(pinInt);

            String facility="";
            if(atmCard.isSelected()){
                facility=facility+" ATM Card";
            }else if(internetBanking.isSelected()){
                facility=facility+" Intenet Banking";
            }else if(mobileBanking.isSelected()){
                facility=facility+" Mobile Banking";
            }else if(emailAlerts.isSelected()){
                facility=facility+" Email and SMS Alerts";
            }else if(checkBook.isSelected()){
                facility=facility+" Cheque Book";
            }else if(eStatement.isSelected()){
                facility=facility+" E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else{
                    Conn conn=new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardNumber+"\n Pin : "+pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[]args){
        new SignUpThree("");
    }
}

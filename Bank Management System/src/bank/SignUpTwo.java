package bank;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox<String> religion,category,income,eduQualification,occupation;
    String formno;

    SignUpTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel rel=new JLabel("Religion : ");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,200,30);
        add(rel);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion= new JComboBox<>(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cat=new JLabel("Category : ");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        add(cat);

        String valCategory[]={"General","OBC","SC","ST","Other"};
        category= new JComboBox<>(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel in=new JLabel("Income : ");
        in.setFont(new Font("Raleway",Font.BOLD,20));
        in.setBounds(100,240,150,30);
        add(in);

        String valIncome[]={"Null","Less than 1,50,000 /-","Less than 2,50,000 /-","Less than 5,00,000 /-","Upto 10,00,000 /-"};
        income= new JComboBox<>(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel education=new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,150,30);
        add(education);


        JLabel qualification=new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,320,150,30);
        add(qualification);

        String valEducation[]={"Non Graduated","Graduated","Post Graduated","Doctrate","Others"};
        eduQualification= new JComboBox<>(valEducation);
        eduQualification.setBounds(300,320,400,30);
        eduQualification.setBackground(Color.WHITE);
        add(eduQualification);

        JLabel occ=new JLabel("Occupation : ");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,390,200,30);
        add(occ);

        String valOccupation[]={"Salaried","Self-Employed","Businessman","Student","Retired","Others"};
        occupation= new JComboBox<>(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan=new JLabel("PAN Number : ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadhar=new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Arial",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel ss=new JLabel("Senior Citizen : ");
        ss.setFont(new Font("Raleway",Font.BOLD,20));
        ss.setBounds(100,540,200,30);
        add(ss);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup ssGroup=new ButtonGroup();
        ssGroup.add(syes);
        ssGroup.add(sno);

        JLabel existing=new JLabel("Existing Account : ");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,590,200,30);
        add(existing);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup=new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)eduQualification.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }

        try{
                Conn c=new Conn();
                String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[]args){
        new SignUpTwo("");
    }
}

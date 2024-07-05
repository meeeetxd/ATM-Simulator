package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton savingsAccRadio,currentAccRadio,FDAccRadio,recurringAccRadio;
    JCheckBox c1, c2, c3 ,c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page:3 Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        savingsAccRadio = new JRadioButton("Savings");
        savingsAccRadio.setFont(new Font("Raleway",Font.BOLD, 16));
        savingsAccRadio.setBackground(Color.WHITE);
        savingsAccRadio.setBounds(100,180,150,30);
        add(savingsAccRadio);
        
        currentAccRadio = new JRadioButton("Current");
        currentAccRadio.setFont(new Font("Raleway",Font.BOLD, 16));
        currentAccRadio.setBackground(Color.WHITE);
        currentAccRadio.setBounds(350,180,250,30);
        add(currentAccRadio);
        
        FDAccRadio = new JRadioButton("Fixed Deposit");
        FDAccRadio.setFont(new Font("Raleway",Font.BOLD, 16));
        FDAccRadio.setBackground(Color.WHITE);
        FDAccRadio.setBounds(100,220,250,30);
        add(FDAccRadio);
        
        recurringAccRadio = new JRadioButton("Recurring");
        recurringAccRadio.setFont(new Font("Raleway",Font.BOLD, 16));
        recurringAccRadio.setBackground(Color.WHITE);
        recurringAccRadio.setBounds(350,220,250,30);
        add(recurringAccRadio);
        
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingsAccRadio);
        accountTypeGroup.add(currentAccRadio);
        accountTypeGroup.add(FDAccRadio);
        accountTypeGroup.add(recurringAccRadio);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel  cardDetail= new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,15));
        cardDetail.setBounds(100,330,300,30);
        add(cardDetail);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel  pin= new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel  pinDetail = new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,15));
        pinDetail.setBounds(100,400,300,30);
        add(pinDetail);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinNumber.setBounds(330,370,200,30);
        add(pinNumber);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,700,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accType = null;
            if(savingsAccRadio.isSelected()){
                accType = "Savings Account";
            }else if(currentAccRadio.isSelected()){
                accType = "Current Account";
            }else if(FDAccRadio.isSelected()){
                accType = "Fixed Diposit";
            }else if(recurringAccRadio.isSelected()){
                accType = "Recurring Account";
            }
            
            Random random = new Random();
            
            String cardNumber =""+ Math.abs((random.nextLong()% 90000000L) + 5040936000000000L);
            
            String pinNumber = ""+Math.abs((random.nextLong()% 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            }else if(c2.isSelected()){
                facility = facility + "Internet Banking";
            }else if(c3.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + "Email and SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility + "Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + "E-Statement";
            }
            
            try{
                if(accType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else if(c7.equals("")){
                    JOptionPane.showMessageDialog(null, "You need to accept the declaration given at the end to proceed");
                }
//               
                Connection c = Conn.getConnection();
                String query = "insert into signupThree(formno,accType,cardNo,PIN,facility) values(?,?,?,?,?);";
                String query2 = "insert into login (formno,cardnumber,pin) values (?,?,?)";
                PreparedStatement stmt = c.prepareStatement(query);
                stmt.setString(1, formno);
                stmt.setString(2, accType);
                stmt.setString(3, cardNumber);
                stmt.setString(4, pinNumber);
                stmt.setString(5, facility);
                
                PreparedStatement stmt2 = c.prepareStatement(query2);
                stmt2.setString(1, formno);
                stmt2.setString(2, cardNumber);
                stmt2.setString(3, pinNumber);
                int rowAffected = stmt2.executeUpdate();
                int rowsAffected = stmt.executeUpdate();
                if(rowsAffected > 0 && rowAffected > 0){
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber + "\n PIN: "+ pinNumber);
                }else
                    JOptionPane.showMessageDialog(null, "error occured while inserting the record");

                }catch(Exception e){
                    e.printStackTrace();
                }
            
        }else if(ae.getSource() == cancel){
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new SignUpThree("");
    }
}

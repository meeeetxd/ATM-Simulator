package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pinText,cnfPinText;
    JButton changePin, back;
    String pinnumber;
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(220, 280, 400, 20);
        image.add(text);
        
        JLabel label1 = new JLabel("New PIN: ");
        label1.setBounds(165, 320, 180 ,25);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(label1);
        
        pinText = new JPasswordField();
        pinText.setFont(new Font("Raleway",Font.BOLD,18));
        pinText.setBounds(330,320,180,25);
        image.add(pinText);
        
        JLabel label2 = new JLabel("Re-Enter New PIN: ");
        label2.setBounds(165, 360, 180 ,25);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(label2);
        
        cnfPinText = new JPasswordField();
        cnfPinText.setFont(new Font("Raleway",Font.BOLD,18));
        cnfPinText.setBounds(330,360,180,25);
        image.add(cnfPinText);
        
        changePin = new JButton("Change Pin");
        changePin.setBounds(355, 455, 150, 30);
        changePin.addActionListener(this);
        image.add(changePin);
        
        back = new JButton("Back");
        back.setBounds(355, 490, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()== changePin){
            try{
                String npin = pinText.getText();
                String rpin = cnfPinText.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return; 
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"New Pin field cannot be empty");
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-enter new Field");
                    return;
                }
                
                Connection con = Conn.getConnection();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupThree set PIN = '"+rpin+"' where PIN='"+pinnumber+"'";
                
                PreparedStatement stmt1 = con.prepareStatement(query1);
                PreparedStatement stmt2 = con.prepareStatement(query2);
                PreparedStatement stmt3 = con.prepareStatement(query3);
                
                stmt1.executeUpdate();
                stmt2.executeUpdate();
                stmt3.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                  
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new PinChange("");
    }
}

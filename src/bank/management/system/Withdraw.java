
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener{
    JButton back, withdraw;
    JTextField amount;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter Amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(210, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setLocation(300,0);
        setSize(900,900);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();

            Date date = new Date(); 
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Amount field cannot be empty");
            }else{

            try{
             Connection c = Conn.getConnection();
               String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
               PreparedStatement stmt = c.prepareStatement(query); 
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null,"Rs "+number+" withdrawl successful");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
               }catch(Exception e){
                   e.printStackTrace();
               }
                
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Withdraw("");
    }
}

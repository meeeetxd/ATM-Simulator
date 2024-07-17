package bank.management.system;
import javax.swing.*;
import java.sql.*;
import java.awt.*;



public class MiniStatement extends JFrame{
    
    
    MiniStatement(String pinnumber){
        
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Connection conn = Conn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from login where pin = '"+pinnumber+"'");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Connection conn = Conn.getConnection();
            int bal = 0;
            PreparedStatement stmt = conn.prepareStatement("select * from bank where pin = '"+pinnumber+"'");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                mini.setText(mini.getText() +"<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br></html>");
                if(rs.getString("type") == "Deposit"){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current balance is Rs. "+bal);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}

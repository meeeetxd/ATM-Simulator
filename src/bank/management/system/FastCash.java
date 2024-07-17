
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    
    JButton amt100,amt10000,amt1000, amt500, back, amt2000, amt5000;
    String pinnumber;
    FastCash(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("PLEASE SELECT WITHDRAWL AMOUNT");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amt100 = new JButton("Rs 100");
        amt100.setBounds(170, 415, 150, 30);
        amt100.addActionListener(this);
        image.add(amt100);
        
        amt500 = new JButton("Rs 500");
        amt500.setBounds(355, 415, 150, 30);
        amt500.addActionListener(this);
        image.add(amt500);
        
        amt1000 = new JButton("Rs 1000");
        amt1000.setBounds(170, 450, 150, 30);
        amt1000.addActionListener(this);
        image.add(amt1000);
        
        amt2000 = new JButton("Rs 2000");
        amt2000.setBounds(355, 450, 150, 30);
        amt2000.addActionListener(this);
        image.add(amt2000);
        
        amt5000 = new JButton("Rs 5000");
        amt5000.setBounds(170, 485, 150, 30);
        amt5000.addActionListener(this);
        image.add(amt5000);
        
        amt10000 = new JButton("Rs 10000");
        amt10000.setBounds(355, 485, 150, 30);
        amt10000.addActionListener(this);
        image.add(amt10000);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount  = ((JButton)ae.getSource()).getText().substring(3); //to remove the "Rs."
            Connection c = Conn.getConnection();
            try{
                String query = "select * from bank where pin = '"+pinnumber+"'";
                PreparedStatement stmt = c.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type")=="Deposit"){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!= back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                PreparedStatement stmt2 = c.prepareStatement(query);
                stmt2.executeUpdate();
                JOptionPane.showMessageDialog(null,"Rs. "+amount+"Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]) {
      new FastCash("");
    }
}

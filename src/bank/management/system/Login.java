/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author Meet Patel
 */
public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear, exitBtn;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setSize(800,480);
        setLocation(350,200); //center
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40, 400, 40); // here 1st is from left to right 2nd position is of top to bottom. 3rd is for total width of the text, and last is for total length of the text
        text.setFont(new Font("Osward", Font.BOLD,38));
        add(text);
        
        JLabel cardNo = new JLabel("Card No.: ");
        cardNo.setBounds(120,150, 150, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD,28));
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font ("Ariel",Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("Pin: ");
        pin.setBounds(120,220, 400, 40);
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        add(pin);
        
        pinTextField = new JPasswordField(4);
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font ("Ariel",Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("Sign In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
        
        clear = new JButton("Clear");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);
        
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(450, 350, 100, 30);
        exitBtn.setBackground(Color.BLACK);
        exitBtn.setForeground(Color.WHITE);
        add(exitBtn);
        exitBtn.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login)
        {
            
        }else if(ae.getSource()== signup){
            new SignUpOne();
        }else if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == exitBtn){
            System.exit(0);
        }
    }

    public static void main(String args[]){
      new Login();
        
    }
}

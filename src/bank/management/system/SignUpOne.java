
package bank.management.system;

//import java.sql.Driver;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignUpOne  extends JFrame implements ActionListener{
    JTextField nameTextField,FnameTextField,emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    long random;
    JButton nextBtn;
    JRadioButton married, unmarried, male, female;
    JDateChooser dateChooser;
    SignUpOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+ 1000L);
        
        JLabel formNo = new JLabel("APPLICATION FORM NO. "+ random);
        formNo.setBounds(140,20,600,40);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        add(formNo);
        
        JLabel prsnlDetails = new JLabel("Page 1: Personal Details");
        prsnlDetails.setBounds(290,80,400,30);
        prsnlDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(prsnlDetails);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fname);
        
        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        FnameTextField.setBounds(300, 190, 400, 30);
        add(FnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.red);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 290, 200, 30);
        add(male);
      
        female = new JRadioButton("Female");        
        female.setBackground(Color.WHITE);
        female.setBounds(500, 290, 200, 30);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email");
        email.setBounds(100, 340, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status");
        marital.setBounds(100, 390, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 200, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500, 390, 200, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        
        JLabel address = new JLabel("Address");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State");
        state.setBounds(100, 540, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode");
        pincode.setBounds(100, 590, 200, 30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
        nextBtn = new JButton("Next");
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setBounds(620, 660, 80,30);
        nextBtn.addActionListener(this);
        add(nextBtn);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno =""+ random;
        String name = nameTextField.getText();
        String fname = FnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name cannot be empty");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name cannot be empty");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email cannot be empty");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address cannot be empty");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City cannot be empty");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State cannot be empty");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pincode cannot be empty");
            }else{
                try{
//               Conn c = new Conn();
                Connection c = Conn.getConnection();
                String query = "insert into signup(formno,name,father_name,dob,gender,email,marital,address,city,state,pincode) values(?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement stmt = c.prepareStatement(query);
                stmt.setString(1,formno);
                stmt.setString(2, name);
                stmt.setString(3, fname);
                stmt.setString(4, dob);
                stmt.setString(5, gender);
                stmt.setString(6, email);
                stmt.setString(7, marital);
                stmt.setString(8, address);
                stmt.setString(9, city);
                stmt.setString(10, state);
                stmt.setString(11, pin);
                int rowsAffected = stmt.executeUpdate();
                if(rowsAffected > 0){
                    setVisible(false);
                    new SignUpTwo().setVisible(true);
                }else
                    JOptionPane.showMessageDialog(null, "error occured while inserting the record");

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        new SignUpOne();
    }
}


package bank.management.system;

//import java.sql.Driver;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignUpTwo  extends JFrame implements ActionListener{
    JTextField  PANTextField, aadharTextField;
    long random;
    JButton nextBtn;
    JRadioButton seniorYes, seniorNo, AccountYes, AccountNo;
    JComboBox categorySelect, religionSelect, incomeSelect, educationSelect,occupationSelect;
    
    SignUpTwo(){
        setLayout(null);
        
        JLabel title = new JLabel("NEW ACCOUNT APPLICATION FORM Page-2");
        title.setBounds(140,20,600,40);
        title.setFont(new Font("Raleway", Font.BOLD, 28));
        add(title);
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290,80,400,30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion");
        religion.setBounds(100, 140, 100, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);
         
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionSelect = new JComboBox(valReligion);
//        religionSelect.setFont(new Font("Raleway",Font.BOLD,20));
        religionSelect.setBounds(300, 140, 400, 30);
        add(religionSelect);
        
        JLabel category = new JLabel("Category:");
        category.setBounds(100, 190, 200, 30);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        add(category);
        
        String valCategory[] = {"General","OBC","SC","ST","Others"};
        categorySelect = new JComboBox(valCategory);
//        categorySelect.setFont(new Font("Raleway",Font.BOLD,20));
        categorySelect.setBounds(300, 190, 400, 30);
        add(categorySelect);
        
        JLabel income = new JLabel("Income: ");
        income.setBounds(100, 240, 200, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);
        
        String incomeCategory[] = {"NULL","<1,50,000","<2,50,000","<3,50,000","<5,00,000","Upto 10,00,000"};
        incomeSelect = new JComboBox(incomeCategory);
        incomeSelect.setBounds(300, 240, 400, 30);
        add(incomeSelect);
        
        JLabel education = new JLabel("Education");
        education.setBounds(100, 290, 200, 30);
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        add(education);
        
        String educationCategory[] = {"Non-Graduate","Graduate","Post-Graduation","Doctrate","Others"};
        educationSelect = new JComboBox(educationCategory);
        educationSelect.setBounds(300, 290, 400, 30);
        educationSelect.setBackground(Color.WHITE);
        add(educationSelect);
      
        JLabel occupation = new JLabel("Occupation");
        occupation.setBounds(100, 340, 200, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        add(occupation);
        
        String occupationCategory[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupationSelect = new JComboBox(occupationCategory);
        occupationSelect.setBounds(300,340,400,30);
        occupationSelect.setBackground(Color.WHITE);
        add(occupationSelect);
        
        JLabel PAN = new JLabel("PAN Number");
        PAN.setBounds(100, 440, 200, 30);
        PAN.setFont(new Font("Raleway", Font.BOLD, 20));
        add(PAN);
        
        PANTextField = new JTextField();
        PANTextField.setFont(new Font("Raleway",Font.BOLD,20));
        PANTextField.setBounds(300, 440, 400, 30);
        add(PANTextField);
        
        JLabel aadhar = new JLabel("Aadhar number:");
        aadhar.setBounds(100, 490, 200, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen");
        seniorCitizen.setBounds(100, 540, 200, 30);
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        add(seniorCitizen);
        
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300, 540, 200, 30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);
        
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(500, 540, 200, 30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorYes);
        seniorCitizenGroup.add(seniorNo);
        
        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setBounds(100, 590, 200, 30);
        existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        add(existingAcc);
        
        AccountYes = new JRadioButton("Yes");
        AccountYes.setBounds(300, 590, 200, 30);
        AccountYes.setBackground(Color.WHITE);
        add(AccountYes);
        
        AccountNo = new JRadioButton("No");
        AccountNo.setBounds(500, 590, 200, 30);
        AccountNo.setBackground(Color.WHITE);
        add(AccountNo);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(AccountYes);
        accountGroup.add(AccountNo);
        
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
        String sReligion = (String) religionSelect.getSelectedItem();
        String sCategory = (String) categorySelect.getSelectedItem();
        String sIncome = (String) incomeSelect.getSelectedItem();
        String sEducation = (String) educationSelect.getSelectedItem();
        String sOccupation = (String) occupationSelect.getSelectedItem();
        
        String senior = null;
        if(seniorYes.isSelected()){
            senior = "Yes";
        }else if(seniorNo.isSelected()){
            senior = "Female";
        }
        
        String aadharCard = aadharTextField.getText();
        
        String existingAccount = null;
        if(AccountYes.isSelected()){
            existingAccount = "Yes";
        } else if(AccountNo.isSelected()){
            existingAccount = "No";
        }
        
        String panCard = PANTextField.getText();
        
        
        
        try{
            if(sReligion.equals("")){
                JOptionPane.showMessageDialog(null,"Religion cannot be empty");
            }else if(sCategory.equals("")){
                JOptionPane.showMessageDialog(null,"Category cannot be empty");
            }else if(sIncome.equals("")){
                JOptionPane.showMessageDialog(null,"Income cannot be empty");
            }else if(sEducation.equals("")){
                JOptionPane.showMessageDialog(null,"Education cannot be empty");
            }else if(sOccupation.equals("")){
                JOptionPane.showMessageDialog(null,"Occupation cannot be empty");
            }else if(panCard.equals("")){
                JOptionPane.showMessageDialog(null,"Pan Card cannot be empty");
            }else if(aadharCard.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Card cannot be empty");
            }else{
                try{
//               Conn c = new Conn();
                Connection c = Conn.getConnection();
                String query = "insert into signupTwo(formno,religion,category,income,education,occupation,PAN,aadharNo,seniorCitizen,exisitingAccount) values(?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement stmt = c.prepareStatement(query);
                stmt.setString(1,formno);
                stmt.setString(2, sReligion);
                stmt.setString(3, sCategory);
                stmt.setString(4, sIncome);
                stmt.setString(5, sEducation);
                stmt.setString(6, sOccupation);
                stmt.setString(7, panCard);
                stmt.setString(8, aadharCard);
                stmt.setString(9, senior);
                stmt.setString(10, existingAccount);
                
                int rowsAffected = stmt.executeUpdate();
                
                if(rowsAffected > 0){
                    setVisible(false);
                new SignUpThree(formno).setVisible(true);
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
        new SignUpTwo();
    }
}

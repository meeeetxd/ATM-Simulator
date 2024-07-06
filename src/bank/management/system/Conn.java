package bank.management.system;
import java.sql.*;
import java.sql.Driver;

public class Conn {
    public static Connection con;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","meet21");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}


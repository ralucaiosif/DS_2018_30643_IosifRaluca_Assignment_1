package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class DBConnection {

    public static void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport","root","");
            System.out.println("Connected to DB");
        } catch(Exception e){
            System.out.println("Failed to connect to DB");
            e.printStackTrace();
        }
    }
}

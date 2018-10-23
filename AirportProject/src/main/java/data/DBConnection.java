package data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {

  /*  public static void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport","root","");
            System.out.println("Connected to DB");
        } catch(Exception e){
            System.out.println("Failed to connect to DB");
            e.printStackTrace();
        }
    }*/

    private static Session session;
    private static SessionFactory sessionFactory;

    public static Session connectToDB() {
        sessionFactory= new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }
}

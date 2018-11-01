package data.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {
    private static SessionFactory sessionFactory;

    public static SessionFactory connectToDB() {
       // Session session;
        sessionFactory= new Configuration().configure().buildSessionFactory();
       // session = sessionFactory.openSession();
      //  return session;
        return sessionFactory;
    }
}

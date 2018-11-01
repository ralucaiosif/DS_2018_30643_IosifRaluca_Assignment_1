package data.dao;

import data.connection.DBConnection;
import org.hibernate.Session;

public abstract class AbstractDAO {

    protected static Session session;

    public Session getSession() {
        if (session == null) {
            session = DBConnection.connectToDB().openSession();
        }
        return session;
    }
}

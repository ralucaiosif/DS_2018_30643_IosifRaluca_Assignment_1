package data.dao;

import data.dto.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private Session session;

    public UserDaoImpl(Session session){
        this.session = session;
    }
    @Override
    public User login(String username, String password) {
        User user = getUserByUsername(username);
        if (user == null){
            System.out.println("Username not found");
            return null;
        }
        if (user.getPassword().equals(password)){
            System.out.println("Login successful");
            return user;
        }
        System.out.println("Invalid credentials");
        return null;
    }

    public User getUserByUsername(String username) {
        Transaction tx = session.beginTransaction();
        List<User> users = null;
        Query query = session.createQuery("select u FROM User u  WHERE u.username = :username ");
        query.setParameter("username", username);
        users = query.list();
        tx.commit();
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }
}

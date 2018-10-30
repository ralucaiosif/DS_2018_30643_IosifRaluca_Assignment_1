package business.BL;

import data.dao.UserDao;
import data.dao.UserDaoImpl;
import data.dto.User;
import org.hibernate.SessionFactory;

public class UserBL {

    private UserDao userDao;

    public UserBL() {
        userDao = new UserDaoImpl();
    }

    public User login(String username, String password){
        return userDao.login(username, password);
    }

}

package data.dao;

import data.dto.User;

public interface UserDao {

    User login(String username, String password);
}

package data.dao;

import data.dto.User;

public interface UserDao {

    public User login(String username, String password);
}

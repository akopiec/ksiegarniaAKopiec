package pl.umcs.dao;

import pl.umcs.entity.User;

public interface UserDAO {

    User getUser(String username);
    void saveUser(User user);
}

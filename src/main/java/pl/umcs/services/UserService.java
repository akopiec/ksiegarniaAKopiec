package pl.umcs.services;

import pl.umcs.entity.User;

public interface UserService {

    User getUser(String username);
    void saveUser(User user);
}

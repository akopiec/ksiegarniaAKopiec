package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.dao.UserDAO;
import pl.umcs.entity.User;
@Service
public class UserService {

//    private UserDAO userDAO;
//    public UserServiceImpl(UserDAO userDAO){
//        this.userDAO=userDAO;
//    }
//    public User getUser(String username){return userDAO.getUser(username);}
//    public void saveUser(User user){}


   private final UserDAO userDAO;
    //private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
        //this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User getUser(String username)
    {
        return userDAO.getUser(username);
    }
    @Transactional
    public void saveUser(User user)
    {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);}
}

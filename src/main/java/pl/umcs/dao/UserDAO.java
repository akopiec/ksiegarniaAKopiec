package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.User;

import javax.persistence.NoResultException;
@Repository
public class UserDAO {

    private SessionFactory sessionFactory;


    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Autowired
    public UserDAO(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public User getUser(String username) {

        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where id = :username", User.class);

        query.setParameter("username", username);

        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public void saveUser(User user) {

        user.setPassword(getPasswordEncoder().encode(user.getPassword()));

        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}

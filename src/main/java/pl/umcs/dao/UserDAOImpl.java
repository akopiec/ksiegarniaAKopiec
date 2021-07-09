package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.User;

import javax.persistence.NoResultException;
@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public User getUser(String username)
    {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id = :username", User.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public void saveUser(User user)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}

package pl.umcs.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Authority;

@Repository
public class AuthorityDAO {

    @Autowired
    private SessionFactory sf;

    public void saveAuthority(Authority authority){

        Session session=sf.getCurrentSession();

        session.save(authority);
    }
}

package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Author;

import java.util.List;
@Repository
public class AuthorDAOImpl implements AuthorDAO  {

    private final SessionFactory sessionFactory;
    @Autowired
    public AuthorDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Author> getAuthors()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Author> query = session.createQuery("from Author", Author.class);
        return query.getResultList();
    }
    @Override
    public void saveAuthor(Author author)
    {
        sessionFactory.getCurrentSession().save(author);
    }
    @Override
    public Author getAuthor(int authorId)
    {
        return sessionFactory.getCurrentSession().get(Author.class, authorId);
    }
    @Override
    public void deleteAuthor(int authorId)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Author WHERE id = :id");
        query.setParameter("id", authorId);
        query.executeUpdate();
    }
}


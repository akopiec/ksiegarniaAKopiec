package pl.umcs.dao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO{

    private  final SessionFactory sessionFactory;
    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Book> getBooks()
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("from Book", Book.class);
        return query.getResultList();
    }
    @Override
    public void saveBook(Book book)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
    }
    @Override
    public Book getBook(Long bookId)
    {
        return sessionFactory.getCurrentSession().get(Book.class,bookId);
    }
    @Override
    public void deleteBook(Long bookId)
    {Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Book WHERE id = :id");
        query.setParameter("id", bookId);
        query.executeUpdate();
    }
}

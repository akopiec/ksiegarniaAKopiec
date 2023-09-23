package pl.umcs.dao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class BookDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public BookDAO(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public List<Book> getBooks() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Book> query = currentSession.createQuery("from Book", Book.class);

        return query.getResultList();
    }

    public void saveBook(Book book) {

        sessionFactory.getCurrentSession().saveOrUpdate(book);
    }

    public Book getBook(Long bookId) {

        return sessionFactory.getCurrentSession().get(Book.class,bookId);
    }

    public void deleteBook(Long bookId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("DELETE FROM Book b WHERE b.id = :id");

        query.setParameter("id", bookId);

        query.executeUpdate();
    }
}

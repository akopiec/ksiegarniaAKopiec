package pl.umcs.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Book;
import pl.umcs.entity.Comment;

import java.util.List;

@Repository
public class CommentDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public CommentDAO(SessionFactory sessionFactory){

        this.sessionFactory=sessionFactory;
    }

    public void saveComment(Comment comment, Book book){

        Session currentSseesion=sessionFactory.getCurrentSession();

        comment.setBook(book);

        currentSseesion.saveOrUpdate(comment);
    }
    public List<Comment> getComments(Book book){

        List<Comment> commentList;

        Session currentSession=sessionFactory.getCurrentSession();

        Query<Comment> query=currentSession.createQuery("select c from Comment c where c.book=:id",Comment.class).setParameter("id",book);

        commentList=query.getResultList();

        return commentList;

    }
}

package pl.umcs.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.dao.CommentDAO;
import pl.umcs.entity.Book;
import pl.umcs.entity.Comment;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    CommentDAO commentDAO;
    @Autowired
    public CommentService(CommentDAO commentDAO){

        this.commentDAO=commentDAO;
    }
    @Transactional
    public void saveComment(Comment comment, Book book){

        commentDAO.saveComment(comment,book);
    }

    @Transactional
    public List<Comment> getComments(Book id){

        List<Comment> commentList=commentDAO.getComments(id);

        return commentList;
    }
}

package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.dao.AuthorDAO;
import pl.umcs.entity.Author;

import java.util.List;
@Service
public class AuthorService {

    private final AuthorDAO authorDAO;
    @Autowired
    public AuthorService(AuthorDAO authorDAO) {

        this.authorDAO = authorDAO;
    }

    @Transactional
    public List<Author> getAuthors() {

        return authorDAO.getAuthors();
    }

    @Transactional
    public void saveAuthor(Author author) {

        authorDAO.saveAuthor(author);
    }

    @Transactional
    public Author getAuthor(int authorId) {

        return authorDAO.getAuthor(authorId);
    }

    @Transactional
    public void deleteAuthor(int authorId) {

        authorDAO.deleteAuthor(authorId);
    }
}


package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.dao.AuthorDAO;
import pl.umcs.entity.Author;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDAO authorDAO;
    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO)
    {
        this.authorDAO = authorDAO;
    }
    @Override
    @Transactional
    public List<Author> getAuthors()
    {
        return authorDAO.getAuthors();
    }
    @Override
    @Transactional
    public void saveAuthor(Author author)
    {
        authorDAO.saveAuthor(author);
    }
    @Override
    @Transactional
    public Author getAuthor(int authorId)
    {
        return authorDAO.getAuthor(authorId);
    }
    @Override
    @Transactional
    public void deleteAuthor(int authorId)
    {
        authorDAO.deleteAuthor(authorId);
    }
}


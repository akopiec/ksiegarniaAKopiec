package pl.umcs.dao;

import pl.umcs.entity.Author;
import pl.umcs.entity.Book;

import java.util.List;

public interface AuthorDAO {

    List<Author> getAuthors();
    void saveAuthor(Author author);
    Author getAuthor(int authorId);
    void deleteAuthor(int authorId);
}

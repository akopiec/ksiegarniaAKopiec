package pl.umcs.dao;

import pl.umcs.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getBooks();
    void saveBook(Book book);
    Book getBook(Long bookId);
    void deleteBook(Long bookId);
}

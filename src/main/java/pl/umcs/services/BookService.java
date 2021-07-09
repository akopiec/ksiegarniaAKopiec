package pl.umcs.services;
import pl.umcs.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    void saveBook(Book book);
    Book getBook(long bookId);
    void deleteBook(long bookId);
}

package pl.umcs.services;


import pl.umcs.dao.BookDAO;
import pl.umcs.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
    @Service
    public class BookService {

        BookDAO bookDAO;

        @Autowired
        public BookService(BookDAO bookDAO) {

            this.bookDAO = bookDAO;
        }

        @Transactional
        public List<Book> getBooks() {

            return bookDAO.getBooks();
        }

        @Transactional
        public void saveBook(Book book) {

            bookDAO.saveBook(book);
        }

        @Transactional
        public Book getBook(long bookId) {

            return bookDAO.getBook(bookId);
        }

        @Transactional
        public void deleteBook(long bookId) {

            bookDAO.deleteBook(bookId);
        }
    }



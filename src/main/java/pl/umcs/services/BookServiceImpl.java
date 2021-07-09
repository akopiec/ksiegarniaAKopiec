package pl.umcs.services;



import pl.umcs.dao.BookDAO;
import pl.umcs.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
    @Service
    public class BookServiceImpl implements BookService {
        BookDAO bookDAO;
        @Autowired
        public BookServiceImpl(BookDAO bookDAO)
        {
            this.bookDAO = bookDAO;
        }
        @Override
        @Transactional
        public List<Book> getBooks()
        {
            return bookDAO.getBooks();
        }
        @Override
        @Transactional
        public void saveBook(Book book)
        {
            bookDAO.saveBook(book);
        }
        @Override
        @Transactional
        public Book getBook(long bookId)
        {
            return bookDAO.getBook(bookId);
        }
        @Override
        @Transactional
        public void deleteBook(long bookId)
        {bookDAO.deleteBook(bookId);
        }
    }



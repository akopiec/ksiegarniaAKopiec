package pl.umcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.umcs.Cart;
import pl.umcs.entity.Book;
import pl.umcs.services.BookService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Controller
@RequestMapping("/cart")
public class CartController {


    private final BookService bookService;
    private final Cart cart;  //= new Cart();

    @Autowired
    public CartController(BookService bookService,Cart cart) {
        this.bookService = bookService;
        this.cart=cart;
    }


    @GetMapping("/dodajDoKoszyka")
    public String dodajDoKoszyka(@RequestParam("bookId") long bookId, Model model) {
        cart.addBookId(bookId);
        List<Book> listbook = new ArrayList<>();
        Iterator<Long> iter = cart.getBookId().iterator();
        while (iter.hasNext()) {
            listbook.add(bookService.getBook(iter.next()));

        }
        model.addAttribute("listBook", listbook);
        return "books/koszykBook";
    }

    @GetMapping("/usunZKoszyka")
    public String usunZKoszyka(@RequestParam("bookId") long bookId, Model model) {

        cart.deletaId(bookId);
        List<Book> listbook = new ArrayList<>();
        Iterator<Long> iter = cart.getBookId().iterator();
        while (iter.hasNext()) {
            listbook.add(bookService.getBook(iter.next()));
        }
        model.addAttribute("listBook", listbook);
        return "books/koszykBook";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        List<Book> listbook = new ArrayList<>();
        Iterator<Long> iter = cart.getBookId().iterator();
        while (iter.hasNext()) {
            listbook.add(bookService.getBook(iter.next()));}
            model.addAttribute("listBook", listbook);
            return "books/koszykBook";
        }


}



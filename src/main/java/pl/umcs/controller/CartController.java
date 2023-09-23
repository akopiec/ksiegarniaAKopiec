package pl.umcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umcs.Cart;
import pl.umcs.entity.Book;
import pl.umcs.services.BookService;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private  BookService bookService;
    @Autowired
    private  Cart cart;

    @GetMapping("/addToCart")
    public String dodajDoKoszyka(@RequestParam("bookId") long bookId) {

        int quantity=1;

        cart.addBookId(bookId,quantity);

        return "redirect:/cart/list";
    }

    @GetMapping("/deleteFromCart")
    public String usunZKoszyka(@RequestParam("bookId") long bookId, Model model) {

        cart.deletaId(bookId);

        Map<Long,Integer> mapbook = cart.getBooksId();

        Map<Book,Integer>  mapbookToModel=new HashMap<>();

        mapbook.forEach((k,v)->mapbookToModel.put(bookService.getBook(k),v));

        model.addAttribute("mapBook",mapbookToModel);

        return "books/cartBook";
    }

    @GetMapping("/list")
    public String list(Model model) {

        Map<Long,Integer> mapbook = cart.getBooksId();

        Map<Book,Integer>  mapbookToModel=new HashMap<>();

        mapbook.forEach((k,v)->mapbookToModel.put(bookService.getBook(k),v));

        model.addAttribute("mapBook", mapbookToModel);

        return "books/cartBook";

        }


}



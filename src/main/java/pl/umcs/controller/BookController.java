package pl.umcs.controller;
import org.springframework.web.bind.annotation.*;
import pl.umcs.Cart;
import pl.umcs.entity.Book;
import pl.umcs.entity.Category;
import pl.umcs.services.AuthorService;
import pl.umcs.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import pl.umcs.services.CategoryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
            private final BookService bookService;
          private  final CategoryService categoryService;
          private  final AuthorService authorService;
          //private BookService bookService;
          private final Cart cart=new Cart();

    @Autowired
    public BookController(BookService bookService,
                          AuthorService authorService,
                          CategoryService categoryService)
    {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    /*@Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
        private  BookService bookService;
        @Autowired
        public BookController(BookService bookService)
        {
            this.bookService = bookService;*/

        @GetMapping("/list")
        public String listBook(Model model)
        {
            List<Book> result = bookService.getBooks();
            model.addAttribute("books", result);
            return "books/list";
        }
    @GetMapping("/formadd")
    public String addForm(Model model)
    {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authorService.getAuthors());
        return "books/formadd";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book)
    {
        bookService.saveBook(book);
        return "redirect:/books/list";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam("bookId") long bookId, Model model)
    {
        model.addAttribute("book", bookService.getBook(bookId));
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authorService.getAuthors());
        return "books/formadd";
    }
    @GetMapping("delete")
    public String deleteBook(@RequestParam("bookId") long bookId)
    {
        bookService.deleteBook(bookId);
        return "redirect:/books/list";
    }

    @GetMapping("/dodajDoKoszyka")
    public String dodajDoKoszyka(@RequestParam("bookId")long bookId,Model model){
       cart.addBookId(bookId);
       List<Book> listbook=new ArrayList<>();
       Iterator<Long> iter=cart.getBookId().iterator();
       while(iter.hasNext()){
           listbook.add(bookService.getBook(iter.next()));

       }model.addAttribute("listBook",listbook);
       return "books/koszykBook";

    }

   /* @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        model.addAttribute("authors", authorService.getAuthors());
        return "books/form";*/

    }


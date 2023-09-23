package pl.umcs.controller;
import org.springframework.web.bind.annotation.*;
import pl.umcs.Cart;
import pl.umcs.entity.Book;
import pl.umcs.entity.Comment;
import pl.umcs.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CommentService commentService;

    private  Cart cart;

    @GetMapping("/list")
        public String listBook(Model model) {

            List<Book> result = bookService.getBooks();

            model.addAttribute("books", result);

            return "books/list";
        }



    @GetMapping("/formadd")
    public String addForm(Model model) {

        Book book = new Book();

        model.addAttribute("book", book);

        model.addAttribute("categories", categoryService.getCategories());

        model.addAttribute("authors", authorService.getAuthors());

        return "books/formadd";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {

        bookService.saveBook(book);

        return "redirect:/books/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("bookId") long bookId, Model model) {

        model.addAttribute("book", bookService.getBook(bookId));

        model.addAttribute("categories", categoryService.getCategories());

        model.addAttribute("authors", authorService.getAuthors());

        return "books/formadd";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") long bookId,Model model) {

        bookService.deleteBook(bookId);

        List<Book> result = bookService.getBooks();

        model.addAttribute("books", result);

        return "/books/list";
    }
    @GetMapping("/detail/{bookId}")
    public String bookDetail(@PathVariable("bookId")long bookId,Model model){

        Book book;

        book=bookService.getBook(bookId);

        List<Comment> commentList=commentService.getComments(book);

        model.addAttribute("book",book);

        model.addAttribute("listComment",commentList);

        return "books/detail";
    }

    @GetMapping("/comment/{bookId}")
    public String formComment(Model model){

        model.addAttribute("comment",new Comment());

        return "books/comment";
    }
    @PostMapping("/comment/{bookId}")
    public String addComment(@ModelAttribute("comment")Comment comment,@PathVariable("bookId")long bookId,Model model){

        Comment commentadd=new Comment();

        String description=comment.getDescription();

        commentadd.setDescription(description);

        LocalDate created= LocalDate.now();

        LocalDate updated=LocalDate.now();

        commentadd.setCreated(created);

        commentadd.setUpdated(updated);

        Book book=bookService.getBook(bookId);

        commentService.saveComment(commentadd,book);

        List<Comment> commentList=commentService.getComments(book);

        model.addAttribute("listComment",commentList);

        model.addAttribute("book",book);

        return "redirect:/books/detail/{bookId}";
    }

}


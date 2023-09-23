package pl.umcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.umcs.Cart;
import pl.umcs.entity.Book;
import pl.umcs.entity.Order;
import pl.umcs.entity.OrderItem;
import pl.umcs.entity.User;
import pl.umcs.services.BookService;
import pl.umcs.services.OrderItemService;
import pl.umcs.services.OrderService;
import pl.umcs.services.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    BookService bookService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    UserService userService;
    @Autowired
    Cart cart;

    @GetMapping("/addOrder")
    public String addOrder(Model model){

        Map<Long,Integer> mapbook = cart.getBooksId();

        Map<Book,Integer>  mapbookToModel=new HashMap<>();

        mapbook.forEach((k,v)->mapbookToModel.put(bookService.getBook(k),v));

        float totalPrice=0;

        float price;

        int quantity;

        for(Map.Entry<Book,Integer> entry:mapbookToModel.entrySet()){

            Book book=entry.getKey();

            price=book.getPrice();

            quantity= entry.getValue();

            totalPrice=totalPrice+(price*quantity);

        }
        model.addAttribute("mapbook",mapbookToModel);

        model.addAttribute("totalPrice",totalPrice);

        return "order";
    }
    @PostMapping("/addOrder")
    public String saveOrder(){

        LocalDate created=LocalDate.now();

        LocalDate updated=LocalDate.now();

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String username=authentication.getName();

        User user=userService.getUser(username);

        Order order=new Order();

        order.setCreated(created);

        order.setUpdated(updated);

        order.setUser(user);

        orderService.saveOrder(order);

        Map<Long,Integer> mapbook=cart.getBooksId();

        Map<Book,Integer>  mapbookToModel=new HashMap<>();

        mapbook.forEach((k,v)->mapbookToModel.put(bookService.getBook(k),v));

        mapbookToModel.forEach(((k,v)->{OrderItem orderItemSecond=new OrderItem();orderItemSecond.setBook(k);orderItemSecond.setQuantity(v);

        orderItemSecond.setOrder(order); orderItemService.saveOrderBook(orderItemSecond);}));

        cart.remoweAll();

        return "redirect:/orderCreated";
    }

}

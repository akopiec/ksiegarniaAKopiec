package pl.umcs.entity;


import javax.persistence.*;

@Entity
@Table(name="zamowioneKsiazki")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;
    @OneToOne
    @JoinColumn(name = "id_book")
    private Book book;

    public OrderItem() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public Order getOrder() {

        return order;
    }

    public void setOrder(Order order) {

        this.order = order;
    }

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {

        this.book = book;
    }
}

package pl.umcs.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="zamowienia")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="created")
    private LocalDate created;
    @Column(name="updated")
    private LocalDate updated;
    @Column(name = "paid")
    private Boolean paid;
    @OneToMany
    @JoinColumn(name = "order")
    private List<OrderItem> orderItemList;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Order(){

    }

    public Order(Long id) {

        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public LocalDate getCreated() {

        return created;
    }

    public void setCreated(LocalDate created) {

        this.created = created;
    }

    public LocalDate getUpdated() {

        return updated;
    }

    public void setUpdated(LocalDate updated) {

        this.updated = updated;
    }

    public Boolean getPaid() {

        return paid;
    }

    public void setPaid(Boolean paid) {

        this.paid = paid;
    }

    public List<OrderItem> getOrderItemList() {

        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {

        this.orderItemList = orderItemList;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }
}

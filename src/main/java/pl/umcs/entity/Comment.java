package pl.umcs.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="komentarze")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="description")
    private String description;
    @Column(name="created")
    private LocalDate created;
    @Column(name="updated")
    private LocalDate updated;
    @ManyToOne
    @JoinColumn(name="id_book")
    private Book book;

    public Comment() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
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

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {

        this.book = book;
    }
}

package pl.umcs.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Autorzy")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "imie")
    private String firstName;
    @Column(name = "nazwisko")
    private String lastName;
    @ManyToMany
    @JoinTable(name = "autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "ksiazka_id"))
    List<Book> books;

    public Author()
    {
        books = new ArrayList<>();
    }
    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        books = new ArrayList<>();
    }
    public Author(String id)
    {
        this.id = Long.parseLong(id);
    }


    public Long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String imie)
    {
        this.firstName = imie;
    }

    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String nazwisko)
    {
        this.lastName = nazwisko;
    }
    public List<Book> getBooks()
    {
        return books;
    }
    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
    public void addBook(Book book)
    {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
    public void removeBook(Book book)
    {
        books.remove(book);
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    @Override
    public String toString()
    {
        return getFullName();
    }
}

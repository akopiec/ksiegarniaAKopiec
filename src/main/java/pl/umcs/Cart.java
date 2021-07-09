package pl.umcs;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class Cart {public Set<Long> booksIds;
    public Cart(){  booksIds=new HashSet<>();}
    public void addBookId(Long id){booksIds.add(id);}
    public void deletaId(Long id){booksIds.remove(id); }
    public Set<Long> getBookId(){return booksIds;}
}

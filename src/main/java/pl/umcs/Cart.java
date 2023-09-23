package pl.umcs;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class Cart {

    int quantity;

    Map<Long,Integer> booksIds;

    public int getQuantity(){

        return quantity;
    }
    public Cart(){

        booksIds=new HashMap<>();
    }
    public void addBookId(Long id,int quantity){

        int quantityNew;

        if (booksIds.containsKey(id)) {

            int quantityOfBook=booksIds.get(id);

            quantityNew=quantity+quantityOfBook;

            booksIds.put(id,quantityNew);
        }
        else {booksIds.put(id,quantity);
        }
    }
    public void deletaId(Long id){

        booksIds.remove(id);
    }

    public Map<Long,Integer> getBooksId(){

        return booksIds;
    }
    
    public void remoweAll(){

        booksIds.forEach((k,v)->booksIds.remove(k));
    }
}

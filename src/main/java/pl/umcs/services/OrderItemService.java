package pl.umcs.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.dao.OrderItemDAO;
import pl.umcs.entity.OrderItem;

import javax.transaction.Transactional;

@Service
public class OrderItemService {

    @Autowired
    public OrderItemDAO orderBookDAO;

    @Transactional
    public void saveOrderBook(OrderItem orderItem){

        orderBookDAO.saveOrderBook(orderItem);
    }
}


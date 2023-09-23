package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.dao.OrderDAO;
import pl.umcs.entity.Order;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    public OrderDAO orderDAO;

    @Transactional
    public void saveOrder(Order order){

        orderDAO.saveOrder(order);
    }
}

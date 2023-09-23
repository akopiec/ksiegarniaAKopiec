package pl.umcs.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.OrderItem;

import javax.transaction.Transactional;

@Repository
public class OrderItemDAO {


    SessionFactory sessionFactory;
    @Autowired
    public OrderItemDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Transactional
    public void saveOrderBook(OrderItem orderItem){

        sessionFactory.getCurrentSession().save(orderItem);
    }
}

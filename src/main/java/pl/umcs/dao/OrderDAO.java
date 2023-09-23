package pl.umcs.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Order;

import javax.transaction.Transactional;

@Repository
public class OrderDAO {

    SessionFactory sessionFactory;
    @Autowired
    public OrderDAO(SessionFactory sessionFactory){

        this.sessionFactory=sessionFactory;
    }

    @Transactional
    public void saveOrder(Order order){

        sessionFactory.getCurrentSession().save(order);
    }
}

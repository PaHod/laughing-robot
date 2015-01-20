package dao;

import domain.Operator;
import domain.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Oles on 17.07.2014.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public Long create(Order order) {
        return (Long) factory.getCurrentSession().save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order read(Long id) {
        return (Order) factory.getCurrentSession().get(Order.class, id);
    }

    @Override
    @Transactional
    public void update(Order order) {
        factory.getCurrentSession().update(order);
    }

    @Override
    @Transactional
    public void delete(Order order) {
        factory.getCurrentSession().delete(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return factory.getCurrentSession().createCriteria(Order.class).list();
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}

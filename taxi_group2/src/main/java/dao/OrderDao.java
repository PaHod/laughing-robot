package dao;

import domain.Operator;
import domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oles on 17.07.2014.
 */
@Repository
public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    void update(Order orde);
    void delete(Order orde);
    List<Order> findAll();
}

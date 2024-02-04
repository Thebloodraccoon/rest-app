package org.hillel.rest.dao;

import org.jvnet.hk2.annotations.Contract;
import org.hillel.rest.model.Order;

import java.util.List;

@Contract
public interface OrderDao {
    Order save(Order order);
    List<Order> findAll();
    Order find(Integer id);
}

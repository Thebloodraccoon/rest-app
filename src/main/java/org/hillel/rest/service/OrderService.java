package org.hillel.rest.service;

import org.hillel.rest.model.dto.OrderDTO;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Integer orderId);
    OrderDTO createOrder(OrderDTO orderDTO);
}

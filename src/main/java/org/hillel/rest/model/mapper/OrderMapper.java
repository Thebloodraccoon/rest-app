package org.hillel.rest.model.mapper;

import org.hillel.rest.model.Order;
import org.hillel.rest.model.dto.OrderDTO;

public interface OrderMapper {
    OrderDTO orderToOrderDTO(Order order);
    Order orderDTOToOrder(OrderDTO order);
}

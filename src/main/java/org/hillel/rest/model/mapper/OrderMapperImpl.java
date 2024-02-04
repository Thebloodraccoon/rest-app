package org.hillel.rest.model.mapper;

import org.hillel.rest.model.Order;
import org.hillel.rest.model.dto.OrderDTO;

public class OrderMapperImpl implements OrderMapper {
    public OrderMapperImpl() {
    }

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if (order != null) {
            return OrderDTO.builder()
                    .id(order.getId())
                    .date(order.getDate())
                    .cost(order.getCost())
                    .products(order.getProducts())
                    .build();
        }
        return null;
    }

    @Override
    public Order orderDTOToOrder(OrderDTO orderDTO) {
        if (orderDTO != null) {
            return Order.builder()
                    .id(orderDTO.getId())
                    .date(orderDTO.getDate())
                    .cost(orderDTO.getCost())
                    .products(orderDTO.getProducts())
                    .build();
        }
        return null;
    }
}

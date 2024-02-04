package org.hillel.rest.service;

import jakarta.inject.Inject;
import org.hillel.rest.dao.OrderDao;
import org.hillel.rest.model.Order;
import org.hillel.rest.model.dto.OrderDTO;
import org.hillel.rest.model.mapper.OrderMapper;
import org.jvnet.hk2.annotations.Service;

import java.util.List;


@Service
public class OrderServiceDefault implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private OrderMapper orderMapper;

    public List<OrderDTO> getAllOrders() {
        List<Order> all = orderDao.findAll();

        return all.stream()
                .map(orderMapper::orderToOrderDTO)
                .toList();
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        Order order = orderDao.find(orderId);

        return orderMapper.orderToOrderDTO(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.orderDTOToOrder(orderDTO);

        Order savedOrder = orderDao.save(order);

        return orderMapper.orderToOrderDTO(savedOrder);
    }

}

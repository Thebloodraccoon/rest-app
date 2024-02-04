package org.hillel.rest.resoure;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hillel.rest.model.Order;
import org.hillel.rest.model.dto.OrderDTO;
import org.hillel.rest.service.OrderService;

import java.util.List;

@Path("orders")
public class OrderResource {
    @Inject
    private OrderService orderService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        final List<OrderDTO> allOrders = orderService.getAllOrders();

        return Response.ok(allOrders).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int orderId) {
        OrderDTO order = orderService.getOrderById(orderId);

        return Response.ok(order).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderDTO orderDTO) {
        OrderDTO created = orderService.createOrder(orderDTO);

        return Response.ok(created).build();
    }

}

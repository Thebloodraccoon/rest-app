package org.hillel.rest.resoure;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hillel.rest.model.dto.OrderDTO;
import org.hillel.rest.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.List;

@Path("orders")
public class OrderResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderResource.class);
    @Inject
    private OrderService orderService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        String path = MDC.get("path");
        final List<OrderDTO> allOrders = orderService.getAllOrders();

        return Response.ok(allOrders).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int orderId) {
        LOGGER.info("Get order by id");
        LOGGER.debug("Order id: {}", orderId);

        OrderDTO order = orderService.getOrderById(orderId);

        return Response.ok(order).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderDTO orderDTO) {
        LOGGER.info("Create Order");
        LOGGER.debug("Order id: {}", orderDTO.getId());
        OrderDTO created = orderService.createOrder(orderDTO);

        return Response.ok(created).build();
    }

}

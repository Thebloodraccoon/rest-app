package org.hillel.rest.dao;

import jakarta.inject.Inject;
import org.jvnet.hk2.annotations.Service;
import org.hillel.rest.exception.NotFoundException;
import org.hillel.rest.exception.NotSavedException;
import org.hillel.rest.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMySQLDao implements OrderDao {
    @Inject
    private Connection connection;

    @Override
    public Order save(Order order)  {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO t_order (date, cost) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, java.sql.Date.valueOf(order.getDate()));
            statement.setDouble(2, order.getCost());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new NotSavedException("Insertion failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            } else {
                throw new NotSavedException("Insertion failed, no ID obtained.");
            }

        } catch (SQLException e) {
            throw new NotSavedException(String.format("Unable to save order 'id': %s", order.getId()));
        }

        return order;
    }


    @Override
    public List<Order> findAll() {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM t_order")) {
            ResultSet resultSet = statement.executeQuery();

            List<Order> orders = new ArrayList<>();

            while (resultSet.next()) {
                Order order = Order.builder()
                        .id(resultSet.getInt("id"))
                        .date(resultSet.getDate("date").toLocalDate())
                        .cost(resultSet.getDouble("cost"))
                        .build();

                orders.add(order);
            }

            return orders;
        } catch (SQLException e) {
            throw new NotFoundException(String.format("Unable to find orders: %s", e.getMessage()));
        }
    }

    @Override
    public Order find(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM t_order WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return Order.builder()
                    .id(resultSet.getInt("id"))
                    .date(resultSet.getDate("date").toLocalDate())
                    .cost(resultSet.getDouble("cost"))
                    .build();
        } catch (SQLException e) {
            throw new NotFoundException(String.format("Unable to find orders: %s", e.getMessage()));
        }
    }
}

package org.hillel.rest.di;


import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.hillel.rest.dao.OrderDao;
import org.hillel.rest.dao.OrderMySQLDao;
import org.hillel.rest.model.mapper.OrderMapper;
import org.hillel.rest.model.mapper.OrderMapperImpl;
import org.hillel.rest.service.OrderService;
import org.hillel.rest.service.OrderServiceDefault;

import java.sql.Connection;

@Provider
public class CustomAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(new DatabaseConnectionFactory())
                .to(Connection.class)
                .in(Singleton.class);

        // Dao
        bind(OrderMySQLDao.class)
                .to(OrderDao.class)
                .in(Singleton.class);

        // Service
        bind(OrderServiceDefault.class)
                .to(OrderService.class)
                .in(Singleton.class);

        bind(OrderMapperImpl.class)
                .to(OrderMapper.class)
                .in(Singleton.class);
    }
}
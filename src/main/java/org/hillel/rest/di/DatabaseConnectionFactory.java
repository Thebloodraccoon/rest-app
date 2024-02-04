package org.hillel.rest.di;

import org.glassfish.hk2.api.Factory;
import org.hillel.rest.db.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionFactory implements Factory<Connection> {
    @Override
    public Connection provide() {
        try {
            final String url = System.getenv("MYSQL_URL");
            final String user = System.getenv("MYSQL_USER");
            final String password = System.getenv("MYSQL_PASSWORD");

            Connection connection = JdbcConnectionUtil.getConnection(url, user, password);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dispose(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

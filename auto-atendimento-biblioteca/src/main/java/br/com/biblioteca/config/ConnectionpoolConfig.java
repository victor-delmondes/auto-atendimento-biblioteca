package br.com.biblioteca.config;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionpoolConfig {

    private ConnectionpoolConfig() {
        getDataSource();
    }

    private static BasicDataSource dataSource;

    private static BasicDataSource getDataSource() {

        if (dataSource == null) {

            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:h2:~/test");
            dataSource.setUsername("sa");
            dataSource.setPassword("sa");
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(50);

            System.out.println("Pool de conexões criado com sucesso");

        }

        return dataSource;

    }

    public static Connection getConnection() throws SQLException {

    return getDataSource().getConnection();

    }

}

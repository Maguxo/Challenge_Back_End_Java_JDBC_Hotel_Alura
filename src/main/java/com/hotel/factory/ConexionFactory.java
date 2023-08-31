package com.hotel.factory;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionFactory {

    private DataSource dataSource;

    public ConexionFactory() {

        var poolDataSource = new ComboPooledDataSource();
        poolDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura_one?useTimeZone=true&serverTimeZone=UTC");
        poolDataSource.setUser("root");
        poolDataSource.setPassword("Escorpions6");
        poolDataSource.setMaxPoolSize(6);

        this.dataSource = poolDataSource;
    }

    public Connection recuperaConexion() {

        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }
}
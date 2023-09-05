package com.hotel.pruebas;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.factory.ConexionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaPoolConexiones {

    public static void main(String[] args) throws SQLException {

        ConexionFactory conexionFactory= new ConexionFactory();

        for(int i= 0; i<20; i++) {
            Connection con= conexionFactory.recuperaConexion();

            System.out.println("Aabriendo la conexión de número " + (i + 1));

            con.close();
        }
    }
}

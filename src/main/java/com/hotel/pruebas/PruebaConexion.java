package com.hotel.pruebas;

import com.hotel.controller.ControllerLogin;
import com.hotel.factory.ConexionFactory;
import com.hotel.model.AdministradorLoguin;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args)throws SQLException {
        //Connection con= new ConexionFactory().recuperaConexion();

        //System.out.println("Cerrando la conexión");

        //con.close();

        /*ControllerLogin controllerLogin= new ControllerLogin();

        var co= controllerLogin.listar();

        for (AdministradorLoguin ad: co){
            System.out.println(String.format(
                    "{usuario: %s y contraseña: %s}",
                    ad.getUsuario(),
                    ad.getPassword_user()));
        }*/



    }
}

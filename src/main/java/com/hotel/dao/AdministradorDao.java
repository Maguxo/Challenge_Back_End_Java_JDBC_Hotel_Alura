package com.hotel.dao;

import com.hotel.model.AdministradorLoguin;
import com.hotel.views.Loguin;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDao {

    private Connection con;
    private Boolean comprueba2;

    public AdministradorDao(Connection connection) {
        this.con = connection;
    }


    public List<AdministradorLoguin> listar(String usuario, String password) { //para poder loguearme desde la base de datos. encuentra el regustro y si está, accedo al interior del programa.
         String comprueba= "";

            List<AdministradorLoguin> resultado = new ArrayList<>();
            try {
                final PreparedStatement statement = con.prepareStatement(
                        "SELECT * FROM ADMINISTRADORlOGUIN WHERE USUARIO= '" + usuario + "' and PASSWORD_USER= '" + password + "'");
                try (statement) {
                    final ResultSet resultSet = statement.executeQuery();
                    try (resultSet) {
                        if (resultSet.next()) {
                       /* var loguin= new AdministradorLoguin(
                                resultSet.getString("USUARIO"),
                                resultSet.getString("PASSWORD_USER"));
                        resultado.add(loguin);*/
                           JOptionPane.showMessageDialog(
                                    null, "¡Acceso peritido!,¡Bienvenido a Hotel Alura!","¡Bienvenido!", JOptionPane.INFORMATION_MESSAGE) ;
                           comprueba2=true;

                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o Contraseña no válidos.");
                            comprueba2=false;

                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return resultado;
        }
    public  Boolean getValidar() {
        return this.comprueba2 =comprueba2;
    }

}
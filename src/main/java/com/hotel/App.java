package com.hotel;

import com.hotel.views.*;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Organizando proyecto" );
        EventQueue.invokeLater(() -> {
            try {
                ControllerView controllerView= new ControllerView();
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                Loguin login= new Loguin();
                MenuUsuarios menu= new MenuUsuarios();
                ReservasView reservasView= new ReservasView();
                RegistroHuespedes huesped= new RegistroHuespedes();
                Busqueda busqueda= new Busqueda();
                Exito exito=new Exito();

                menuPrincipal.setControllerView(controllerView);
                login.setControllerView(controllerView);
                menu.setControllerView(controllerView);
                busqueda.setControllerView(controllerView);
                reservasView.setControllerView(controllerView);
                huesped.setControllerView(controllerView);
                exito.setControllerView(controllerView);

                controllerView.setMenuPrincipal(menuPrincipal);
                controllerView.setLoguin(login);
                controllerView.setMenuUsuarios(menu);
                controllerView.setBusqueda(busqueda);
                controllerView.setReservasView(reservasView);
                controllerView.setRegistroHuespedes(huesped);
                controllerView.setExito(exito);

                controllerView.mostrarMenuPrincipal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

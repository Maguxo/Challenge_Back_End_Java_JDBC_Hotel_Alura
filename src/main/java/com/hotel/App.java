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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //MenuPrincipal frame = new MenuPrincipal();
                    //frame.setVisible(true);
                    //Loguin login= new Loguin();
                    //login.setVisible(true);
                    //MenuUsuarios menu= new MenuUsuarios();
                    //menu.setVisible(true);
                    //ReservasView reservasView= new ReservasView();
                   // reservasView.setVisible(true);
                    RegistroHuespedes huesped= new RegistroHuespedes();
                    huesped.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

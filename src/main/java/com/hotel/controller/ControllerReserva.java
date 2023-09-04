package com.hotel.controller;

import com.hotel.dao.ReservaDao;
import com.hotel.factory.ConexionFactory;
import com.hotel.model.Reservas;

import java.sql.Date;
import java.util.List;

public class ControllerReserva {

         private ReservaDao reservaDao;

         public  ControllerReserva(){

             this.reservaDao= new ReservaDao(new ConexionFactory().recuperaConexion());
         }
        public int eliminaReserva(Integer id) {
             return reservaDao.eliminaReserva(id);
        }
        public int modificarReserva(Date fechaEntrada, Date fechaSalida, Double valor, String formaPago,Integer id) {
            return reservaDao.modificaReservas(fechaEntrada,fechaSalida,valor,formaPago, id);
        }
         public List<Reservas> listaReserva(){ //para listar la tabla.
                return reservaDao.listarReservas();
            }
                 public void insertarReservas(Reservas reservas){

             reservaDao.insertarReserva(reservas);
         }
}

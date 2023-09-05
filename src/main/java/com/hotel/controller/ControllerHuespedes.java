package com.hotel.controller;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.dao.HuespedDao;
import com.hotel.factory.ConexionFactory;
import com.hotel.model.Huespedes;
import java.sql.Date;
import java.util.List;

public class ControllerHuespedes {

    private HuespedDao huespedDao;
    public ControllerHuespedes(){
        this.huespedDao= new HuespedDao(new ConexionFactory().recuperaConexion());
    }
    public List<Huespedes> buscarPorIdApe(String lastName){
        return huespedDao.buscarPorApeId(lastName);
    }
    public int eliminaHuesped(Integer id) {
        return huespedDao.eliminaHuespedes(id);
    }
    public int modificaHuesped(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono, Integer id) {
      return  huespedDao.modificaHuespedes(nombre,apellido,nacimiento,nacionalidad,telefono,id);
    }
    public List<Huespedes> listaHuespedes(){
        return huespedDao.listaHuespedes();
    }
    public void insertarHuesped(Huespedes huespedes, Integer idReserva){
        huespedes.setId_reserva(idReserva);
        huespedDao.insertarHuesped(huespedes);
    }
}

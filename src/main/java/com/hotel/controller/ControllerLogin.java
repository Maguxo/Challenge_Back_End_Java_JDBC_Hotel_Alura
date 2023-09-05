package com.hotel.controller;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.dao.AdministradorDao;
import com.hotel.factory.ConexionFactory;
import com.hotel.model.AdministradorLoguin;

import java.util.List;

public class ControllerLogin {

    private AdministradorDao administradorDao;
    public ControllerLogin(){
        var factory= new ConexionFactory();
        this.administradorDao=new AdministradorDao(factory.recuperaConexion());
    }
    public List<AdministradorLoguin> listar(String user, String passWord){
        return administradorDao.listar(user,passWord);
    }
    public Boolean getValida(){
        return administradorDao.getValidar();
    }

}

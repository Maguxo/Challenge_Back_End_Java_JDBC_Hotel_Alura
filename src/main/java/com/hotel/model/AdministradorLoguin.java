package com.hotel.model;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
public class AdministradorLoguin {

    private Integer id;
    private String usuario;
    private String password_user;

    public AdministradorLoguin(Integer id, String usuario, String password_user) {
        this.id = id;
        this.usuario = usuario;
        this.password_user = password_user;
    }
    public AdministradorLoguin( String usuario, String password_user) {
        this.usuario = usuario;
        this.password_user = password_user;
    }
    public AdministradorLoguin(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }



}

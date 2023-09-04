package com.hotel.model;

import java.sql.Date;

public class Huespedes {

    private Integer id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String telefono;
    private Integer id_reserva;

    public void Huuespedes() {
    }

    public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer id_reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id_reserva = id_reserva;
    }

    public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer id_reserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id_reserva = id_reserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    @Override
    public String toString() {
        return String.format(
                "{id: %s, nombre: %s, apellido: %s, fechanacimiento: %s, nacionalidad: %s, telefeono: %s}",
                this.id,
                this.nombre,
                this.apellido,
                this.fechaNacimiento,
                this.nacionalidad,
                this.telefono);
    }
}
package com.hotel.model;
import java.sql.Date;

public class Reservas {
    private  Integer id;
    private Date fechaEntrada;
    private Date fechaSalidada;
    private Double valor;
    private String formaPago;

    public Reservas(){}
    public Reservas(Integer id, Date fechaEntrada, Date fechaSalidada, Double valor, String formaPago) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalidada = fechaSalidada;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public Reservas(Date fechaEntrada, Date fechaSalidada, Double valor, String formaPago) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalidada = fechaSalidada;
        this.valor = valor;
        this.formaPago = formaPago;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Date getFechaSalidada() {
        return fechaSalidada;
    }
    public void setFechaSalidada(Date fechaSalidada) {
        this.fechaSalidada = fechaSalidada;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public String toString() {
        return String.format(
                "{id: %s, entrada: %s, salida: %s, valor: %s, F.pago: %s }",
                this.id,
                this.fechaEntrada,
                this.fechaSalidada,
                this.valor,
                this.formaPago);
    }
}

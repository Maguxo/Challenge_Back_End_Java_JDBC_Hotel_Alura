package com.hotel.dao;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.model.Reservas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ReservaDao {

    final private Connection con;
    public ReservaDao(Connection con) {
        this.con = con;
    }
    public int eliminaReserva(Integer id) {

        try {

            final PreparedStatement sta= con.prepareStatement(
                    "DELETE FROM reservas WHERE id = ?");
            try (sta){

                sta.setInt(1, id);
                sta.execute();

                int deleteCount= sta.getUpdateCount();
                return deleteCount;
         }}catch (SQLException e){

            throw new RuntimeException(e);
    }}
    public int modificaReservas(Date fechaEntrada, Date fechaSalida, Double valor, String formaPago, Integer id) {

        try {

            final PreparedStatement sta= con.prepareStatement(
                    "UPDATE reservas SET" +
                            "  fechaEntrada = ?" +
                            ", fechaSalida = ?" +
                            ", valor = ?" +
                            ", formaPago = ?" +
                            "  WHERE id = ?");
            try (sta){

                sta.setDate(1,fechaEntrada);
                sta.setDate(2,fechaSalida);
                sta.setDouble(3,valor);
                sta.setString(4,formaPago);
                sta.setInt(5,id);
            sta.execute();

            int updateCont= sta.getUpdateCount();
            return updateCont;
            }}catch (SQLException e){

            throw new RuntimeException(e);
        }}
    public List<Reservas> listarReservas(){

        List<Reservas> reservas= new ArrayList<>();
        try {

            final PreparedStatement sta= con.prepareStatement(
                    "SELECT id,fechaEntrada,fechaSalida,valor,formaPago FROM reservas");
            try(sta){

                sta.execute();

                final ResultSet resultSet=sta.getResultSet();
                try (resultSet){

                    while (resultSet.next()){

                         reservas.add(new Reservas(
                                 resultSet.getInt("id"),
                                 resultSet.getDate("fechaEntrada"),
                                 resultSet.getDate("fechaSalida"),
                                 resultSet.getDouble("valor"),
                                 resultSet.getString("formaPago")));
            }}}}catch (SQLException e){

            throw new RuntimeException(e);
        }
        return reservas;
    }
    public void insertarReserva(Reservas reservas){

        try (con){

            final PreparedStatement st= con.prepareStatement(
                    "INSERT INTO reservas" +
                            "(fechaEntrada, fechaSalida, valor, formaPago)" +
                            "VALUES(?,?,?,?)");
            try (st){

                st.setDate(1, reservas.getFechaEntrada());
                st.setDate(2, reservas.getFechaSalidada());
                st.setDouble(3,reservas.getValor());
                st.setString(4,reservas.getFormaPago());

                st.execute();
        }}catch (SQLException e){
            throw new RuntimeException(e);
}}}

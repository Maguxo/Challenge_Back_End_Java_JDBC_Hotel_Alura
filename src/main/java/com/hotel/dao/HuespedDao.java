package com.hotel.dao;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.model.Huespedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class HuespedDao {

    final private Connection con;

    public HuespedDao(Connection con) {
        this.con = con;
    }
    public List<Huespedes> buscarPorApeId(String lastName){

        List<Huespedes> huespedes= new ArrayList<>();
        try {

            final PreparedStatement st= con.prepareStatement(
                    "SELECT * FROM huespedes WHERE apellido LIKE "+ "'%"+ lastName +"%'");
            try (st){

                st.execute();
                final ResultSet resultSet= st.getResultSet();
                try (resultSet){

                    while (resultSet.next()){

                        huespedes.add(new Huespedes(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("apellido"),
                                resultSet.getDate("fechaNacimiento"),
                                resultSet.getString("nacionalidad"),
                                resultSet.getString("telefono"),
                                resultSet.getInt("id_reserva")));
            }}}}catch (SQLException e){

            throw new RuntimeException(e);
        }
        return huespedes;
    }
    public int eliminaHuespedes(Integer id) {// elimina registro del la tabla t DB directamente.

        try {

            final PreparedStatement pts= con.prepareStatement(
                    "DELETE FROM huespedes WHERE id = ?");
            try (pts){

                pts.setInt(1,id);
                pts.execute();

                int deletecount= pts.getUpdateCount();
                return deletecount;
            }}catch (SQLException e){

            throw new RuntimeException(e);
        }}
    public int modificaHuespedes(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono, Integer id) {
      //Actualiza los datos de DB y tabla directamente.
        try {

            final PreparedStatement pst= con.prepareStatement(
                    "UPDATE huespedes SET" +
                            "  nombre = ?" +
                            ", apellido = ?" +
                            ", fechaNacimiento = ?" +
                            ", nacionalidad = ?" +
                            ", telefono = ?" +
                            " WHERE id = ?");
            try (pst){

                pst.setString(1,nombre);
                pst.setString(2,apellido);
                pst.setDate(3,nacimiento);
                pst.setString(4,nacionalidad);
                pst.setString(5, telefono);
                pst.setInt(6,id);

              pst.execute();

              int updateCont= pst.getUpdateCount();
              return updateCont;
        }}catch (SQLException e){

            throw new RuntimeException(e);
        }}
    public void insertarHuesped(Huespedes huespedes){ // incorpora datos directamente a la BD y tabla.

        try (con){

            final PreparedStatement st= con.prepareStatement(
                    "INSERT INTO huespedes" +
                            "(nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva)" +
                            "VALUES" +
                            "(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            try (st){

                st.setString(1, huespedes.getNombre());
                st.setString(2, huespedes.getApellido());
                st.setDate(3,huespedes.getFechaNacimiento());
                st.setString(4, huespedes.getNacionalidad());
                st.setString(5, huespedes.getTelefono());
                st.setInt(6,huespedes.getId_reserva());

                st.execute();

                final ResultSet resultSet= st.getGeneratedKeys();
                try (resultSet){

                    System.out.println("Se muestra que sucede"+resultSet);
                    while (resultSet.next()){

                        huespedes.setId(resultSet.getInt(1));
                        System.out.println(
                                String.format(
                                        "Fue insertado el producto de ID %s",huespedes));
                    }}}}catch (SQLException e){

            throw new RuntimeException(e);
        }}
    public List<Huespedes> listaHuespedes() { //me miestra el listado de huespeddes quee xisten para mostrarlo en la tabla.

        List<Huespedes> huespedes= new ArrayList<>();
        try {
             final PreparedStatement st= con.prepareStatement(
                     "SELECT id,nombre,apellido,fechaNacimiento,nacionalidad,telefono,id_reserva FROM huespedes");
            try (st){
                  st.execute();

                  final ResultSet resultSet= st.getResultSet();
                  try (resultSet){
                      while (resultSet.next()){
                          huespedes.add(new Huespedes(
                             resultSet.getInt("id"),
                             resultSet.getString("nombre"),
                             resultSet.getString("apellido"),
                             resultSet.getDate("fechaNacimiento"),
                             resultSet.getString("nacionalidad"),
                             resultSet.getString("telefono"),
                             resultSet.getInt("id_reserva")));

                      }}}}catch (SQLException e){
            throw new RuntimeException(e);
        }
        return huespedes;
}}

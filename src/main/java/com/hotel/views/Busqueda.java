package com.hotel.views;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.controller.ControllerHuespedes;
import com.hotel.controller.ControllerReserva;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Objects;
import java.util.Optional;
public class Busqueda extends JFrame {
    private ControllerView controllerView;
    private ControllerHuespedes controllerHuespedes;
    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes,tbReservas;
    private DefaultTableModel modeloReservas,modeloHuesped;
    private JLabel labelAtras,labelExit, body;
    int xMouse, yMouse;
    private JTabbedPane panel;
    private ControllerReserva controllerReserva;

    public Busqueda() {
        this.controllerReserva= new ControllerReserva();
        this.controllerView= new ControllerView();
        this.controllerHuespedes= new ControllerHuespedes();
        contentPane = new JPanel();
        this.setIconImage(getIconImage());
        this.setBounds(100, 100, 910, 560);
        contentPane.setBackground(new Color(241,241,241));
        contentPane.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.getContentPane().add(contentPane);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        body= new JLabel();
        body.setBounds(0,0,910,560);
        body.setLayout(null);
        body.setIcon(imaBody("/imagenes/busqueda.gif"));
        contentPane.add(body);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        body.add(txtBuscar);
        txtBuscar.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 300, 42);
        body.add(lblNewLabel_4);

        panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        body.add(panel);

        tablaReserva();//actualiza el listado recerva.
        tablaHuespedes();//actualiza el listado hospedaje.

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/Ha100px.png"))));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        body.add(lblNewLabel_2);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controllerView.mostrarMenuUsuario();
                controllerView.noMostrarBusqueda();
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(new Color(12, 138, 199));
            }});
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        body.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        labelAtras.setForeground(new Color(12, 138, 199));
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(new Color(12, 138, 199));
            }});
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        body.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(new Color(12, 138, 199));
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        body.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txtBuscar.getText().isBlank() || txtBuscar.getText().isEmpty()){
                    JOptionPane.showMessageDialog(
                            null, "El campo se encuentre vacio","Campo vacio.",JOptionPane.WARNING_MESSAGE);
                    return;
                }else{
                    controllerHuespedes.buscarPorIdApe(txtBuscar.getText());
                    limpiarTablaHospedaje();
                    cargarBusquedaHospedaje(txtBuscar.getText());
                    JOptionPane.showMessageDialog(
                            null, "","Dato encontrado",JOptionPane.WARNING_MESSAGE);
                }}});
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        body.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        body.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0){ // Hubica tabla reserva.

                    modificarReserva();
                     limpiaTablaReserva();
                     cargarTablaReserva();
                }else if (panel.getSelectedIndex() == 1){

                    modificarHospedaje();
                    limpiarTablaHospedaje();
                    cargarTablaHospedaje();
                }}});
        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        body.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(panel.getSelectedIndex() == 0){// Hubica tabla Huespedes.

                    eliminarReserva();
                    limpiaTablaReserva();
                    cargarTablaReserva();
                }else if(panel.getSelectedIndex() == 1){

                    eliminarHospedaje();
                    limpiarTablaHospedaje();
                    cargarTablaHospedaje();
                }}});
    }
    private void tablaHuespedes(){
        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
        modeloHuesped.addColumn("Número de Huesped");
        modeloHuesped.addColumn("Nombre");
        modeloHuesped.addColumn("Apellido");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        modeloHuesped.addColumn("Número de Reserva");
        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        cargarTablaHospedaje();
        panel.addTab("Huéspedes", new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/pessoas.png"))), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);
    }
    private void tablaReserva(){
        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloReservas = (DefaultTableModel) tbReservas.getModel();
        modeloReservas.addColumn("Numero de Reserva");
        modeloReservas.addColumn("Fecha Check In");
        modeloReservas.addColumn("Fecha Check Out");
        modeloReservas.addColumn("Valor");
        modeloReservas.addColumn("Forma de Pago");
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        cargarTablaReserva();
        panel.addTab("Reservas", new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/reservado.png"))), scroll_table, null);
        scroll_table.setVisible(true);
        filaElegidaReserva();
    }
    private void modificarHospedaje(){
        if(filaElegidaHospedaje()){
            JOptionPane.showMessageDialog(this,"No has seleccionado nunguna fila de la tabla Hospedajes.");
            return;
        }
        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),tbHuespedes.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
                    String nombre = (String) String.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1));
                    String apellido = (String) String.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2));
                    Date nacimiento = Date.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
                    String nacionalidad = (String) String.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4));
                    String telefono = (String) String.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5));


                    var filaModifica= this.controllerHuespedes.modificaHuesped(nombre,apellido,nacimiento,nacionalidad,telefono,id);

                    JOptionPane.showMessageDialog(this,String.format("%d item modificado con exito ",filaModifica));
                },() -> JOptionPane.showMessageDialog(this,"Elige un item Hospedaje."));
    }

    private void eliminarHospedaje(){
        if(filaElegidaHospedaje()){
            JOptionPane.showMessageDialog(this,"No has seleccionado nunguna fila de la tabla Hospedajes.");
            return;
        }
        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),tbHuespedes.getSelectedColumn()))
                .ifPresentOrElse(fila ->{
                    Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),0).toString());

                    var filaEliminada= this.controllerHuespedes.eliminaHuesped(id);

                    modeloHuesped.removeRow(tbHuespedes.getSelectedRow());
                    JOptionPane.showMessageDialog(this,filaEliminada +" ¡Item Huésped eliminada con exito!");

                },() ->JOptionPane.showMessageDialog(this,"Elije item Huésped."));
    }
    private void eliminarReserva(){
        if(filaElegidaReserva()){
            JOptionPane.showMessageDialog(this,"No has seleccionado nunguna fila de la tabla reservas.");
            return;
        }
        Optional.ofNullable(modeloReservas.getValueAt(tbReservas.getSelectedRow(),tbReservas.getSelectedColumn()))
                .ifPresentOrElse(fila ->{
                     Integer id= Integer.valueOf(modeloReservas.getValueAt(tbReservas.getSelectedRow(),0).toString());
                     var filaEliminada= this.controllerReserva.eliminaReserva(id);

                     modeloReservas.removeRow(tbReservas.getSelectedRow());
                     JOptionPane.showMessageDialog(this,filaEliminada +" ¡Item Reserva eliminada con exito!");
                },() -> JOptionPane.showMessageDialog(this,"Elije item Reserva."));

    }
     private void modificarReserva(){
        if(filaElegidaReserva()){
            JOptionPane.showMessageDialog(this,"No has seleccionado nunguna fila de la tabla reservas.");
            return;
        }
         Optional.ofNullable(modeloReservas.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                 .ifPresentOrElse(fila ->{
                     Integer id= Integer.valueOf(modeloReservas.getValueAt(tbReservas.getSelectedRow(),0).toString());
                     Date fechaEntrada= Date.valueOf(modeloReservas.getValueAt(tbReservas.getSelectedRow(),1).toString());
                     Date fechaSalida= Date.valueOf(modeloReservas.getValueAt(tbReservas.getSelectedRow(),2).toString());
                     Double valor= Double.valueOf(modeloReservas.getValueAt(tbReservas.getSelectedRow(),3).toString());
                     String formaPago= (String)modeloReservas.getValueAt(tbReservas.getSelectedRow(),4);

                     var filaModificada= this.controllerReserva.modificarReserva(fechaEntrada,fechaSalida,valor,formaPago,id);
                     JOptionPane.showMessageDialog(this,String.format("%d item modificado con exito ",filaModificada));
                 },() -> JOptionPane.showMessageDialog(this, "Elije un item reserva"));
     }
     private Boolean filaElegidaHospedaje(){
        return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedRowCount() == 0;
     }
    private Boolean filaElegidaReserva(){
        return  tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
    }
    private void cargarBusquedaHospedaje(String apellido){
        var hospedaje= this.controllerHuespedes.buscarPorIdApe(apellido);

            hospedaje.forEach(busca -> modeloHuesped.addRow(
                    new Object[]{
                            busca.getId(),
                            busca.getNombre(),
                            busca.getApellido(),
                            busca.getFechaNacimiento(),
                            busca.getNacionalidad(),
                            busca.getTelefono(),
                            busca.getId_reserva()}));
    }
    private  void cargarTablaHospedaje(){
        var huespedes= this.controllerHuespedes.listaHuespedes();

            huespedes.forEach(hos -> modeloHuesped.addRow(
                    new Object[]{
                            hos.getId(),
                            hos.getNombre(),
                            hos.getApellido(),
                            hos.getFechaNacimiento(),
                            hos.getNacionalidad(),
                            hos.getTelefono(),
                            hos.getId_reserva()}));
    }
    private void cargarTablaReserva(){
        var reservas= this.controllerReserva.listaReserva();

            reservas.forEach(res -> modeloReservas.addRow(
                            new Object[]{
                             res.getId(),
                             res.getFechaEntrada(),
                             res.getFechaSalidada(),
                             res.getValor(),
                             res.getFormaPago()}));
    }
    private void limpiarTablaHospedaje(){
        modeloHuesped.getDataVector().clear();
    }
    private void limpiaTablaReserva(){
        modeloReservas.getDataVector().clear();
    }
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/aH40px.png")).getScaledInstance(100,100,20);
    }
    private ImageIcon imaBody( String login){
        ImageIcon ima1= new ImageIcon(Objects.requireNonNull(getClass().getResource(login)));
        ImageIcon ima2= new ImageIcon(ima1.getImage().getScaledInstance(body.getWidth(),body.getHeight(),Image.SCALE_FAST));
        return ima2;
    }
    public void setControllerView (ControllerView controllerView){
        this.controllerView= controllerView;
    }
    public void tabla(){
        cargarTablaReserva();
    }
    public void tablaHospedaje(){
        cargarTablaHospedaje();
    }
    public void limpiaTReserva(){
        limpiaTablaReserva();
    }
    public void limpiaTHuespedes() {
        limpiarTablaHospedaje();
    }
}

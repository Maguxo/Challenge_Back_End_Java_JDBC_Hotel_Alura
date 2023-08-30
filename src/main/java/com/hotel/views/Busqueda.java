package com.hotel.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class Busqueda extends JFrame {

    public ControllerView controllerView;
    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes,tbReservas;
    private DefaultTableModel modelo,modeloHuesped;
    private JLabel labelAtras,labelExit, body;
    int xMouse, yMouse;

    public Busqueda() {
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

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        body.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/reservado.png"))), scroll_table, null);
        scroll_table.setVisible(true);

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
        panel.addTab("Huéspedes", new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/pessoas.png"))), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

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
    ///ACCIONAR.
            }});
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
}

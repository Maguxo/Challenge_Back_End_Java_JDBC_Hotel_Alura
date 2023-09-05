package com.hotel.views;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
public class MenuUsuarios extends JFrame {
    private ControllerView controllerView;
    private JPanel contentPane;
    int xMouse, yMouse;
    private JLabel labelExit, recepcion;
    private JLabel labelRegistro;
    public MenuUsuarios() {

        contentPane = new JPanel();
        this.setIconImage(getIconImage());
        this.setBounds(100, 100, 944, 609);
        contentPane.setBackground(new Color(241,241,241));
        contentPane.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.getContentPane().add(contentPane);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(12, 138, 199));
        panelMenu.setBounds(0, 0, 257, 609);
        contentPane.add(panelMenu);
        panelMenu.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(50, 58, 150, 150);
        panelMenu.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuarios.class.getResource("/imagenes/aH150px.png"))));

        JPanel btnRegistro = new JPanel();
        btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistro.setBackground(new Color(118, 187, 223));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistro.setBackground(new Color(12, 138, 199));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                controllerView.mostrarReservasView();
                controllerView.noMostrarMenuUsuario();
                dispose();
            }});
        btnRegistro.setBounds(0, 255, 257, 56);
        btnRegistro.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnRegistro);
        btnRegistro.setLayout(null);

        labelRegistro = new JLabel("Registro de reservas");
        labelRegistro.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuarios.class.getResource("/imagenes/reservado.png"))));
        labelRegistro.setForeground(SystemColor.text);
        labelRegistro.setBounds(25, 11, 205, 34);
        labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
        btnRegistro.add(labelRegistro);

        JPanel btnBusqueda = new JPanel();
        btnBusqueda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBusqueda.setBackground(new Color(118, 187, 223));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnBusqueda.setBackground(new Color(12, 138, 199));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               controllerView.mostrarBusqueda();
               controllerView.noMostrarMenuUsuario();
                dispose();
            }});
        btnBusqueda.setBounds(0, 312, 257, 56);
        btnBusqueda.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnBusqueda);
        btnBusqueda.setLayout(null);

        JLabel lblBusquedaDeReservas = new JLabel("Búsqueda");
        lblBusquedaDeReservas.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuarios.class.getResource("/imagenes/pessoas.png"))));
        lblBusquedaDeReservas.setBounds(27, 11, 200, 34);
        lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
        lblBusquedaDeReservas.setForeground(Color.WHITE);
        lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnBusqueda.add(lblBusquedaDeReservas);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 219, 201, 2);
        panelMenu.add(separator);
        header.setLayout(null);
        header.setBackground(new Color(241,241,241));
        header.setBounds(0, 0, 944, 36);
        contentPane.add(header);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(160, 222, 239));
                labelExit.setForeground(Color.white);
            }});
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(160, 222, 239));
        btnexit.setBounds(891, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("<X>");
        labelExit.setBounds(0, 0, 53, 36);
        labelExit.setForeground(Color.white);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel panelFecha = new JPanel();
        panelFecha.setBackground(new Color(118, 187, 223));
        panelFecha.setBounds(256, 84, 688, 121);
        contentPane.add(panelFecha);
        panelFecha.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
        lblNewLabel_1.setBounds(100, 11, 356, 42);
        panelFecha.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));

        JLabel labelFecha = new JLabel("New label");
        labelFecha.setBounds(395, 64, 294, 40);
        panelFecha.add(labelFecha);
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
        Date fechaActual = new Date(); //fecha y hora actual
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
        labelFecha.setText("Hoy es " + fecha); //setear la representacion en cadena de la fecha

        JLabel lblNewLabel = new JLabel("¡Bienvenido!");
        lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        lblNewLabel.setBounds(302, 234, 147, 46);
        contentPane.add(lblNewLabel);

        String textoDescripcion = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel.   </body></html>";
        JLabel labelDescripcion = new JLabel(textoDescripcion);
        labelDescripcion.setFont(new Font("Roboto", Font.PLAIN, 17));

        labelDescripcion.setBounds(312, 291, 598, 66);
        contentPane.add(labelDescripcion);

        String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
        JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
        labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescripcion_1.setBounds(311, 345, 569, 88);
        contentPane.add(labelDescripcion_1);

        JLabel lblNewLabel_3 = new JLabel("- Registro de Reservas y Huéspedes");
        lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(312, 444, 295, 27);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("- Edición de Reservas y Huéspedes existentes");
        lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3_1.setBounds(312, 482, 355, 27);
        contentPane.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros.");
        lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3_2.setBounds(312, 520, 295, 27);
        contentPane.add(lblNewLabel_3_2);

        recepcion= new JLabel();
        recepcion.setBackground(Color.black);
        recepcion.setBounds(690, 402, 250,200);
        recepcion.setIcon(imarecepcionista("/imagenes/recepcionista.gif"));
        recepcion.setOpaque(true);
        contentPane.add(recepcion);
    }
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/aH40px.png")).getScaledInstance(100,100,20);
    }

    private ImageIcon imarecepcionista( String login){
        ImageIcon ima1= new ImageIcon(Objects.requireNonNull(getClass().getResource(login)));
        ImageIcon ima2= new ImageIcon(ima1.getImage().getScaledInstance(recepcion.getWidth(),recepcion.getHeight(),Image.SCALE_FAST));
        return ima2;
    }
    public void setControllerView (ControllerView controllerView){
        this.controllerView= controllerView;
    }
}

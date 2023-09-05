package com.hotel.views;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.controller.ControllerReserva;
import com.hotel.model.Reservas;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.sql.Date;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.concurrent.TimeUnit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import static java.sql.Date.valueOf;

public class ReservasView extends JFrame {
    private ControllerView controllerView;
    private ControllerReserva controllerReserva;
    private JPanel contentPane, btnsiguiente;
    public static JTextField txtValor;
    public static JDateChooser txtFechaEntrada,txtFechaSalida;
    public static JComboBox<String> txtFormaPago;
    private int xMouse, yMouse;
    private JLabel labelExit,imagenFondo,labelAtras,labDolar;
    public ReservasView() {
        super("Reserva");
        this.controllerReserva= new ControllerReserva();
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
        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        contentPane.add(panel);
        panel.setLayout(null);
        // Código que crea los elementos de la interfáz gráfica
        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(SystemColor.textHighlight);
        separator_1_2.setBounds(68, 195, 289, 2);
        separator_1_2.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_2);

        JSeparator separator_1_3 = new JSeparator();
        separator_1_3.setForeground(SystemColor.textHighlight);
        separator_1_3.setBackground(SystemColor.textHighlight);
        separator_1_3.setBounds(68, 453, 289, 2);
        panel.add(separator_1_3);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(SystemColor.textHighlight);
        separator_1_1.setBounds(68, 281, 289, 11);
        separator_1_1.setBackground(SystemColor.textHighlight);
        //panel.add(separator_1_1);

        JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 134, 200, 14);
        lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckIn);

        JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 221, 220, 14);
        lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckOut);

        JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
        lblFormaPago.setForeground(SystemColor.textInactiveText);
        lblFormaPago.setBounds(68, 382, 187, 24);
        lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblFormaPago);

        JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
        lblTitulo.setBounds(100, 60, 250, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(lblTitulo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 560);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/Ha100px.png"))));

        imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 0, 482, 562);
        imagenFondo.setBackground(Color.WHITE);
        imagenFondo.setIcon(gifRecepcionista("/imagenes/recep2.gif"));
        panel_1.add(imagenFondo);

        JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
        lblValor.setForeground(SystemColor.textInactiveText);
        lblValor.setBounds(72, 303, 220, 14);
        lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblValor);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(SystemColor.textHighlight);
        separator_1.setBounds(68, 362, 289, 2);
        separator_1.setBackground(SystemColor.textInactiveText);
        panel.add(separator_1);
        // Componentes para dejar la interfaz con estilo Material Design
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
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setBounds(429, 0, 53, 36);
        imagenFondo.add(btnexit);

        labelExit = new JLabel("<X>");
        labelExit.setForeground(Color.WHITE);
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
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
            }});
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        panel.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controllerView.mostrarMenuUsuario();
                controllerView.noMostrarReservasView();
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
                labelAtras.setForeground(Color.black);
            }});
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));

        JLabel lblSiguiente = new JLabel("SIGUIENTE");
        lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
        lblSiguiente.setForeground(Color.WHITE);
        lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblSiguiente.setBounds(0, 0, 122, 35);
        //Campos que guardaremos en la base de datos
        txtFechaEntrada = new JDateChooser();
        txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/iconreservas.png"))));
        txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
        txtFechaEntrada.setBounds(68, 161, 289, 35);
        txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
        txtFechaEntrada.setBackground(Color.WHITE);
        txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
        txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
        txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
        panel.add(txtFechaEntrada);

        labDolar= new JLabel("USD");
        labDolar.setBackground(SystemColor.window);
        labDolar.setBounds(80,328,50,32);
        labDolar.setForeground(Color.BLACK);
        labDolar.setHorizontalAlignment(SwingConstants.LEFT);
        labDolar.setFont(new Font("Roboto Black", Font.BOLD, 17));
        labDolar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(labDolar);

        txtValor = new JTextField("0.0");
        txtValor.setBackground(SystemColor.window);
        txtValor.setHorizontalAlignment(SwingConstants.LEFT);
        txtValor.setForeground(Color.BLACK);
        txtValor.setBounds(120, 328, 106, 33);
        txtValor.setEditable(false);
        txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
        txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(txtValor);
        txtValor.setColumns(100);

        txtFechaSalida = new JDateChooser();
        txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/iconreservas.png"))));
        txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
        txtFechaSalida.setBounds(68, 246, 289, 35);
        txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
        txtFechaSalida.setBackground(Color.WHITE);
        txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
        /*txtFechaSalida.addPropertyChangeListener(evt -> {
            //Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
        });*/
        txtFechaSalida.setDateFormatString("yyyy-MM-dd");
        txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        panel.add(txtFechaSalida);

        txtFormaPago = new JComboBox();
        txtFormaPago.setBounds(68, 417, 289, 38);
        txtFormaPago.setBackground(SystemColor.text);
        txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
        panel.add(txtFormaPago);

        btnsiguiente = new JPanel();
        btnsiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {

                    txtValor.setText(valorReserva()+"");
                    JOptionPane.showMessageDialog(null,"Cargando reserva...","Interactuando con BD...",JOptionPane.INFORMATION_MESSAGE);
                         insertaDatosReserva();
                         controllerView.cleanTReserva();
                         controllerView.cargarTablaReserva();
                         limpiar();
                         controllerView.mostrarRegistroHuesped();
                         controllerView.noMostrarReservasView();
                         dispose();
                         System.out.println("pasando a la otra ventana");

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.","¡¡¡Atención!!!",JOptionPane.WARNING_MESSAGE);
                }
            }});
        btnsiguiente.setLayout(null);
        btnsiguiente.setBackground(SystemColor.textHighlight);
        btnsiguiente.setBounds(238, 493, 122, 35);
        btnsiguiente.add(lblSiguiente);
        panel.add(btnsiguiente);
        btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void insertaDatosReserva(){
        String fechaEntrada=((JTextField) txtFechaEntrada.getDateEditor().getUiComponent()).getText();
        String fechaSalida=((JTextField)txtFechaSalida.getDateEditor().getUiComponent()).getText();

        var reserva= new Reservas(valueOf(fechaEntrada),
                                  valueOf(fechaSalida),Double.valueOf(txtValor.getText()),
                                  txtFormaPago.getSelectedItem().toString());
        this.controllerReserva.insertarReservas(reserva);
    }
    private  Double valorReserva(){
        Double valor=  10.50;
        String fechaEntrada=((JTextField) txtFechaEntrada.getDateEditor().getUiComponent()).getText();
        String fechaSalida=((JTextField)txtFechaSalida.getDateEditor().getUiComponent()).getText();

       Date entrada= Date.valueOf(fechaEntrada);
       Date salida=  Date.valueOf(fechaSalida);
       Long cal= salida.getTime() - entrada.getTime();
       TimeUnit uni=TimeUnit.DAYS;
       Long hospedajeDias= uni.convert(cal,TimeUnit.MILLISECONDS);
        return valor * hospedajeDias;
    }
    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/aH40px.png")).getScaledInstance(100,100,20);
    }
    private ImageIcon gifRecepcionista(String login){
        ImageIcon ima1= new ImageIcon(Objects.requireNonNull(getClass().getResource(login)));
        ImageIcon ima2= new ImageIcon(ima1.getImage().getScaledInstance(imagenFondo.getWidth(),imagenFondo.getHeight(), Image.SCALE_FAST));
        return ima2;
    }
    public void setControllerView (ControllerView controllerView){
        this.controllerView= controllerView;
    }
    private void limpiar(){
        //txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
        txtFechaSalida.setDateFormatString("yyyy-MM-dd");
        txtFechaSalida.setCalendar(null);
        txtValor.setText("0.0");
    }
}

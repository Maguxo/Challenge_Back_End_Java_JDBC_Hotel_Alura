package com.hotel.views;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import com.hotel.controller.ControllerHuespedes;
import com.hotel.model.Huespedes;
import com.hotel.model.Reservas;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.Format;
import java.util.Objects;
import static java.lang.Integer.*;

public class RegistroHuespedes extends JFrame {
    private ControllerView controllerView;
    private Reservas reservas;
    private ControllerHuespedes controllerHuespedes;
    private JPanel contentPane;
    private JTextField txtNombre,txtApellido,txtTelefono,txtNreserva;
    private JDateChooser txtFechaN;
    private JComboBox<Format> txtNacionalidad;
    private JLabel labelExit,imagenFondo,labelAtras;
    int xMouse, yMouse;
    public RegistroHuespedes() {

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
        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controllerView.mostrarReservasView();
                controllerView.noMostrarRegistroHuesped();
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(new Color(12, 138, 199));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }});
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 489, 634);
        panel.setBackground(new Color(12, 138, 199));
        contentPane.add(panel);
        panel.setLayout(null);

        imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 0, 499, 634);
        imagenFondo.setIcon(gifHuesped("/imagenes/huespedGif.gif"));
        panel.add(imagenFondo);

        btnAtras.setLayout(null);
        btnAtras.setBackground(new Color(12, 138, 199));
        btnAtras.setBounds(0, 0, 53, 36);
        imagenFondo.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setForeground(Color.WHITE);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNombre.setBounds(560, 102, 285, 33);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setColumns(10);
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtApellido.setBounds(560, 174, 285, 33);
        txtApellido.setColumns(10);
        txtApellido.setBackground(Color.WHITE);
        txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtApellido);

        txtFechaN = new JDateChooser();
        txtFechaN.setBounds(560, 238, 285, 36);
        txtFechaN.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(RegistroHuespedes.class.getResource("/imagenes/iconreservas.png"))));
        txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaN.setDateFormatString("yyyy-MM-dd");
        contentPane.add(txtFechaN);

        txtNacionalidad = new JComboBox();
        txtNacionalidad.setBounds(560, 306, 289, 36);
        txtNacionalidad.setBackground(SystemColor.text);
        txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
        contentPane.add(txtNacionalidad);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(562, 79, 253, 14);
        lblNombre.setForeground(SystemColor.textInactiveText);
        lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNombre);

        JLabel lblApellido = new JLabel("APELLIDO");
        lblApellido.setBounds(560, 150, 255, 14);
        lblApellido.setForeground(SystemColor.textInactiveText);
        lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblApellido);

        JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
        lblFechaN.setBounds(560, 218, 255, 14);
        lblFechaN.setForeground(SystemColor.textInactiveText);
        lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblFechaN);

        JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
        lblNacionalidad.setBounds(560, 284, 255, 16);
        lblNacionalidad.setForeground(SystemColor.textInactiveText);
        lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidad);

        JLabel lblTelefono = new JLabel("TELÉFONO");
        lblTelefono.setBounds(562, 352, 253, 16);
        lblTelefono.setForeground(SystemColor.textInactiveText);
        lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtTelefono.setBounds(560, 374, 285, 33);
        txtTelefono.setColumns(10);
        txtTelefono.setBackground(Color.WHITE);
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtTelefono);

        JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
        lblTitulo.setBounds(580, 35, 240, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
        contentPane.add(lblTitulo);

        JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
        lblNumeroReserva.setBounds(560, 414, 253, 16);
        lblNumeroReserva.setForeground(SystemColor.textInactiveText);
        lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNumeroReserva);

        txtNreserva = new JTextField();
        txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNreserva.setBounds(560, 435, 285, 33);
        txtNreserva.setColumns(10);
        txtNreserva.setBackground(Color.WHITE);
        txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNreserva);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(560, 140, 289, 2);
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2);

        JSeparator separator_1_2_1 = new JSeparator();
        separator_1_2_1.setBounds(560, 210, 289, 2);
        separator_1_2_1.setForeground(new Color(12, 138, 199));
        separator_1_2_1.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_1);

        JSeparator separator_1_2_2 = new JSeparator();
        separator_1_2_2.setBounds(560, 274, 289, 2);
        separator_1_2_2.setForeground(new Color(12, 138, 199));
        separator_1_2_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_2);

        JSeparator separator_1_2_3 = new JSeparator();
        separator_1_2_3.setBounds(560, 344, 289, 2);
        separator_1_2_3.setForeground(new Color(12, 138, 199));
        separator_1_2_3.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_3);

        JSeparator separator_1_2_4 = new JSeparator();
        separator_1_2_4.setBounds(560, 407, 289, 2);
        separator_1_2_4.setForeground(new Color(12, 138, 199));
        separator_1_2_4.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_4);

        JSeparator separator_1_2_5 = new JSeparator();
        separator_1_2_5.setBounds(560, 472, 289, 2);
        separator_1_2_5.setForeground(new Color(12, 138, 199));
        separator_1_2_5.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_5);

        JPanel btnguardar = new JPanel();
        btnguardar.setBounds(723, 500, 122, 35);
        btnguardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String fechaNcimiento=((JTextField) txtFechaN.getDateEditor().getUiComponent()).getText();
                if (txtNombre.getText() != null && txtApellido.getText()!= null && txtFechaN.getDate() !=null &&
                        txtNacionalidad.getSelectedItem() !=null && txtTelefono.getText() !=null && txtNreserva.getText() !=null) {
                    insertarRegistroHuespedes(fechaNcimiento);
                    controllerView.cleanTHuespedes();
                    controllerView.cargaerTablaHospedaje();
                    controllerView.mostrarExito();
                    controllerView.noMostrarRegistroHuesped();
                    System.out.println("Registrado.");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.","¡¡¡Atención!!!",JOptionPane.WARNING_MESSAGE);
                }}});
        btnguardar.setLayout(null);
        btnguardar.setBackground(new Color(12, 138, 199));
        contentPane.add(btnguardar);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel labelGuardar = new JLabel("GUARDAR");
        labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
        labelGuardar.setForeground(Color.WHITE);
        labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelGuardar.setBounds(0, 0, 122, 35);
        btnguardar.add(labelGuardar);

        JLabel logo = new JLabel("");
        logo.setBounds(194, 39, 104, 107);
        imagenFondo.add(logo);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(RegistroHuespedes.class.getResource("/imagenes/Ha100px.png"))));

        JPanel btnexit = new JPanel();
        btnexit.setBounds(857, 0, 53, 36);
        btnexit.setBackground(new Color(12, 138, 199));
        contentPane.add(btnexit);
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(new Color(12, 138, 199));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(160, 222, 239));
                labelExit.setForeground(Color.white);
            }});
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(160, 222, 239));

        labelExit = new JLabel("<X>");
        labelExit.setBounds(0, 0, 53, 36);
        labelExit.setForeground(Color.white);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnexit.add(labelExit);
    }
    private void insertarRegistroHuespedes(String fechaNacimiento){
       this.reservas= new Reservas();
        Integer idReserva;
        try {
            idReserva= parseInt(txtNreserva.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, String
                    .format("El campo Número Reserva debe ser numérico dentro del rango %d y %d.", 0, MAX_VALUE));
            return;
        }

        var huesped= new Huespedes(txtNombre.getText(),txtApellido.getText(), Date.valueOf(fechaNacimiento),
                (String) txtNacionalidad.getSelectedItem(),txtTelefono.getText(),idReserva);
        var reserva = valueOf(txtNreserva.getText());
         reservas.setId(reserva);
        this.controllerHuespedes.insertarHuesped(huesped, reservas.getId());

        JOptionPane.showMessageDialog(this, "Registrado con éxito!");
      limpiarFormulario();
    }
    private void limpiarFormulario() {
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtFechaN.setDateFormatString(String.valueOf(0));
        this.txtTelefono.setText("");
        this.txtNreserva.setText("");
        this.txtNacionalidad.setSelectedIndex(0);
    }
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/aH40px.png")).getScaledInstance(100,100,20);
    }
    private ImageIcon gifHuesped(String login){
        ImageIcon ima1= new ImageIcon(Objects.requireNonNull(getClass().getResource(login)));
        ImageIcon ima2= new ImageIcon(ima1.getImage().getScaledInstance(imagenFondo.getWidth(),imagenFondo.getHeight(), Image.SCALE_FAST));
        return ima2;
    }
    public void setControllerView (ControllerView controllerView){
        this.controllerView= controllerView;
    }
}

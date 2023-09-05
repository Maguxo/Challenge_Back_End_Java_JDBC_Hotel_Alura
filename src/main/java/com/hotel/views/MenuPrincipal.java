package com.hotel.views;
/**
 * Developed by Edgar M Gómez P
 * Back-end developer
 * **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;
public class MenuPrincipal extends JFrame{

    private ControllerView controllerView;
    private JPanel contentPane;
    private JLabel labelExit,panelIm,imagenFondo1,imagenLogin,btnLogin;
    private int xMouse, yMouse;

    public MenuPrincipal()  {

        contentPane = new JPanel();
        this.setIconImage(getIconImage());
        this.setBounds(100, 100, 910, 537);
        contentPane.setBackground(new Color(182,228,240));
        contentPane.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.getContentPane().add(contentPane);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        panelIm = new JLabel();
        panelIm.setBounds(0, 0, 600, 500);
        panelIm.setOpaque(true);
        panelIm.setBackground(new Color(255,255,255));
        panelIm.setLayout(null);
        contentPane.add(panelIm);

        imagenFondo1 = new JLabel("");
        imagenFondo1.setBounds(430, 0, 180, 250);
        imagenFondo1.setHorizontalAlignment(SwingConstants.CENTER);
        imagenFondo1.setIcon(inicio("/imagenes/hotel.gif"));
        panelIm.add(imagenFondo1);

        JLabel imagendeFondo2= new JLabel("");
        imagendeFondo2.setBounds(0, 310, 180, 190);
        imagendeFondo2.setHorizontalAlignment(SwingConstants.CENTER);
        imagendeFondo2.setIcon(inicio("/imagenes/hotelRecep.gif"));
        panelIm.add(imagendeFondo2);

        JLabel imagendeFondo3= new JLabel();
        imagendeFondo3.setBounds(250, 180, 136, 180);
        imagendeFondo3.setHorizontalAlignment(SwingConstants.CENTER);
        imagendeFondo3.setIcon(inicio("/imagenes/InicioOpcional2.gif"));
        panelIm.add(imagendeFondo3);

        JLabel logo = new JLabel();
        logo.setBounds(692, 80, 150, 156);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(MenuPrincipal.class.getResource("/imagenes/aH150px.png"))));
        contentPane.add(logo);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBounds(0, 500, 910, 37);
        panel_1.setBackground(new Color(160, 222, 239));
        contentPane.add(panel_1);

        JLabel lblCopyR = new JLabel("Developer by Edgar M Gómez P © 2023");
        lblCopyR.setBounds(315, 11, 314, 19);
        lblCopyR.setForeground(new Color(255, 255, 255));
        lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 12));
        panel_1.add(lblCopyR);

        //Boton para controlar la ventana
        JPanel header = new JPanel();
        header.setBounds(0, 500, 50, 36);
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
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        contentPane.add(header);
        //Botón salir
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
                btnexit.setBackground(Color.white);
                labelExit.setForeground(new Color(160, 222, 239));
            }});
        btnexit.setLayout(null);
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.setBackground(Color.white);
        btnexit.setBounds(857, 0, 53, 36);
        contentPane.add(btnexit);

        labelExit = new JLabel("<X>");
        labelExit.setBounds(0, 0, 53, 36);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setForeground(new Color(160, 222, 239));
        btnexit.add(labelExit);
        //Botón Login
        btnLogin = new JLabel();
        btnLogin.setBounds(704, 300, 120, 120);
        btnLogin.setOpaque(true);
        btnLogin.setBackground(new Color(182,228,240));
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controllerView.mostrarLoguin();
                controllerView.noMostrarMenuPrincipal();
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                imagenLogin.setIcon(imaLoguin("/imagenes/loguinH2.png"));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                imagenLogin.setIcon(imaLoguin("/imagenes/loguinM.png"));
            }});
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //btnLogin.setBackground(SystemColor.window);
        contentPane.add(btnLogin);

        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setBounds(724, 265, 83, 24);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(SystemColor.textHighlight);
        lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
        contentPane.add(lblTitulo);

        imagenLogin = new JLabel();
        imagenLogin.setBounds(0, 0, 120, 120);
        imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLogin.setIcon(imaLoguin("/imagenes/loguinM.png"));
        btnLogin.add(imagenLogin);
    }
    //Código que permite mover la pantalla.
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
    private ImageIcon inicio(String imagen){
        return new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(imagen))).getImage()
                .getScaledInstance(250,250,Image.SCALE_REPLICATE));
    }
    private ImageIcon imaLoguin( String login){
        ImageIcon ima1= new ImageIcon(Objects.requireNonNull(getClass().getResource(login)));
        ImageIcon ima2= new ImageIcon(ima1.getImage().getScaledInstance(imagenLogin.getWidth(),imagenLogin.getHeight(),Image.SCALE_SMOOTH));
        return ima2;
    }
    public void setControllerView (ControllerView controllerView){
        this.controllerView= controllerView;
    }
}

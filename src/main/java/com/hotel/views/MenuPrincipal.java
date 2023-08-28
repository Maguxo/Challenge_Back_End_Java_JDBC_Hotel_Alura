package com.hotel.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class MenuPrincipal extends JFrame{

    private JPanel contentPane;
    private JLabel labelExit,panelIm,imagenFondo1;
    int xMouse, yMouse;

    public MenuPrincipal()  {

        contentPane = new JPanel();
        this.setIconImage(getIconImage());
        this.setBounds(100, 100, 910, 537);
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5))
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
        imagenFondo1.setBounds(300, 50, 260, 250);
        imagenFondo1.setBackground(Color.black);
        imagenFondo1.setIcon(inicio("/imagenes/hotel.gif"));
        panelIm.add(imagenFondo1);

        JLabel imagendeFondo2= new JLabel("");
        imagendeFondo2.setBounds(50, 200, 250, 300);
        imagendeFondo2.setBackground(Color.pink);
        imagendeFondo2.setIcon(inicio("/imagenes/hotelRecep.gif"));
        panelIm.add(imagendeFondo2);


        JLabel logo = new JLabel("");
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

        //Barra para controlar la ventana
        JPanel header = new JPanel();
        header.setBounds(860, 0, 50, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() { //vamos por acá
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
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("<X>");
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        //Botón Login
        JPanel btnLogin = new JPanel();
        btnLogin.setBounds(754, 300, 83, 70);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Login login = new Login();
                //login.setVisible(true);
                dispose();
            }
        });
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setBackground(SystemColor.window);
       // panel.add(btnLogin);

        JLabel imagenLogin = new JLabel("");
        imagenLogin.setBounds(0, 0, 80, 70);
        btnLogin.add(imagenLogin);
        imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLogin.setIcon(new ImageIcon(Objects.requireNonNull(MenuPrincipal.class.getResource("/imagenes/login.png"))));

        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setBounds(754, 265, 83, 24);
        lblTitulo.setBackground(SystemColor.window);
       //panel.add(lblTitulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(SystemColor.textHighlight);
        lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
    }

    //Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"
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
}

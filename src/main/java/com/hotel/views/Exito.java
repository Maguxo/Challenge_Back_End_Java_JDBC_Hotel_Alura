package com.hotel.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Exito extends JDialog {
    private ControllerView controllerView;
    private final JPanel contentPanel = new JPanel();
    private  JLabel body;

    public Exito() {

        this.setIconImage(getIconImage());
        this.setBounds(100, 100, 394, 226);
        //contentPanel.setBackground(new Color(241,241,241));
        contentPanel.setBackground(SystemColor.control);
        contentPanel.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.getContentPane().add(contentPanel,BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        body = new JLabel();
        body.setBounds(0, 0, 394, 226);
        body.setIcon(imaExito("/imagenes/exito.gif"));
        body.setLayout(null);
        contentPanel.add(body);

        {
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(Exito.class.getResource("/imagenes/Ha100px.png"))));
            lblNewLabel.setBounds(123, 11, 100, 100);
            body.add(lblNewLabel);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("¡Datos guardados satisfactoriamente!");
            lblNewLabel_1.setForeground(new Color (0, 35, 173));
            lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
            lblNewLabel_1.setBounds(27, 112, 342, 21);
            body.add(lblNewLabel_1);
        }
                JButton okButton = new JButton("OK");
                okButton.setLayout(null);
                okButton.setOpaque(true);
                okButton.setForeground(new Color(12, 138, 199));
                okButton.setBounds(200,180,60,30);
                okButton.addActionListener(e -> {
                    controllerView.mostrarMenuUsuario();
                    controllerView.noMostrarExito();
                    dispose();//sirve para cerrar la ventana actual
                });
                body.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setLayout(null);
        cancelButton.setForeground(new Color(12, 138, 199));
        cancelButton.setOpaque(true);
        cancelButton.setBounds(270,180,80,30);
        cancelButton.addActionListener(e -> {
            System.exit(0);
            //Accionar.
        } );
        body.add(cancelButton);
            }

    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/aH40px.png")).getScaledInstance(100,100,20);
    }
    private ImageIcon imaExito( String login) {
        ImageIcon ima1 = new ImageIcon(Objects.requireNonNull(getClass().getResource(login)));
        ImageIcon ima2 = new ImageIcon(ima1.getImage().getScaledInstance(body.getWidth(), body.getHeight(), Image.SCALE_FAST));
        return ima2;
    }
    public void setControllerView (ControllerView controllerView){
        this.controllerView= controllerView;
    }
}

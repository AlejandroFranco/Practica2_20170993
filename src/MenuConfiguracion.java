import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuConfiguracion {

    private static JFrame jFrame;
    private static JPanel jPanel;
    private static JLabel textoGrandeControles;
    private static JTextField campoMovimientoAdelante;
    private static JTextField campoMovimientoAtras;
    private static JTextField campoSalto;
    private static JComboBox comboDisparo1;
    private static JComboBox comboDisparo2;
    private static JComboBox comboDisparo3;
    private static JComboBox comboDisparo4;
    private static JButton botonAceptar;
    private static JButton botonCancelar;
    private static ImageIcon iconoCuphead;
    private static JLabel etiquetaPersonaje;
    private static JLabel etiquetaMovimientoAdelante;
    private static JLabel etiquetaMovimientoAtras;
    private static JLabel etiquetaSalto;
    private static JLabel etiquetaDisparo1;
    private static JLabel etiquetaDisparo2;
    private static JLabel etiquetaDisparo3;
    private static JLabel etiquetaDisparo4;

    public static void crearMenuConfiguracion() {

        jFrame = new JFrame();
        jFrame.setPreferredSize(new Dimension(500, 500));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        textoGrandeControles = new JLabel();
        comboDisparo1 = new JComboBox();
        comboDisparo2 = new JComboBox();
        comboDisparo3 = new JComboBox();
        comboDisparo4 = new JComboBox();
        botonAceptar = new JButton();
        botonCancelar = new JButton();
        iconoCuphead = new ImageIcon();
        etiquetaPersonaje = new JLabel();
        etiquetaMovimientoAdelante = new JLabel();
        etiquetaMovimientoAtras = new JLabel();
        etiquetaSalto = new JLabel();
        etiquetaDisparo1 = new JLabel();
        etiquetaDisparo2 = new JLabel();
        etiquetaDisparo3 = new JLabel();
        etiquetaDisparo4 = new JLabel();

        textoGrandeControles.setText("Configuracion Controles");
        c.gridx = 1;
        c.gridy = 1;
        jPanel.add(textoGrandeControles, c);

        etiquetaMovimientoAdelante.setText("Movimiento Adelante");
        c.gridx = 1;
        c.gridy = 2;
        jPanel.add(etiquetaMovimientoAdelante, c);

        campoMovimientoAdelante = new JTextField();
        c.gridx = 2;
        c.gridy = 2;
        jPanel.add(campoMovimientoAdelante, c);

        etiquetaMovimientoAtras.setText("Movimiento Atras");
        c.gridx = 1;
        c.gridy = 3;
        jPanel.add(etiquetaMovimientoAtras, c);

        campoMovimientoAtras = new JTextField();
        c.gridx = 2;
        c.gridy = 3;
        jPanel.add(campoMovimientoAtras, c);

        etiquetaSalto.setText("Salto");
        c.gridx = 1;
        c.gridy = 4;
        jPanel.add(etiquetaSalto, c);

        campoSalto = new JTextField();
        c.gridx = 2;
        c.gridy = 4;
        jPanel.add(campoSalto, c);

        etiquetaDisparo1.setText("Disparo 1");
        c.gridx = 1;
        c.gridy = 5;
        jPanel.add(etiquetaDisparo1, c);

        comboDisparo1 = new JComboBox();
        c.gridx = 2;
        c.gridy = 5;
        jPanel.add(comboDisparo1, c);

        etiquetaDisparo2.setText("Disparo 2");
        c.gridx = 1;
        c.gridy = 6;
        jPanel.add(etiquetaDisparo2, c);

        comboDisparo2 = new JComboBox();
        c.gridx = 2;
        c.gridy = 6;
        jPanel.add(comboDisparo2, c);

        etiquetaDisparo3.setText("Disparo 3");
        c.gridx = 1;
        c.gridy = 7;
        jPanel.add(etiquetaDisparo3, c);

        comboDisparo3 = new JComboBox();
        c.gridx = 2;
        c.gridy = 7;
        jPanel.add(comboDisparo3, c);

        etiquetaDisparo4.setText("Disparo 4");
        c.gridx = 1;
        c.gridy = 8;
        jPanel.add(etiquetaDisparo4, c);

        comboDisparo4 = new JComboBox();
        c.gridx = 2;
        c.gridy = 8;
        jPanel.add(comboDisparo4, c);

        botonAceptar.setText("Aceptar");
        c.gridx = 1;
        c.gridy = 9;
        jPanel.add(botonAceptar, c);

        botonCancelar.setText("Cancelar");
        botonCancelar.addMouseListener(new AdaptadorMouse());
        c.gridx = 2;
        c.gridy = 9;
        jPanel.add(botonCancelar, c);

        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
        jFrame.pack();

    }

    private static class AdaptadorMouse extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == botonCancelar) {
                jFrame.dispose();
                MenuPrincipal.crearMenu();
            } else if (e.getSource() == botonAceptar) {
                //guardo la configuracion y cambio de pantalla
                jFrame.dispose();
                MenuPrincipal.crearMenu();
            }
        }

    }
}



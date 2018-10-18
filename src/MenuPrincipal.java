
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;

public class MenuPrincipal {
    private  static FF fileFilter;
    private static JTextField movimientoAdelante;
    private static JTextField movimientoAtras;
    private static JTextField salto;
    private static JComboBox disparo1;
    private static JButton botonconfigurarControles;
    private static JButton botoniniciarJuego;
    private static JButton botoncontinuarJuego;
    private static JButton botonsalir;
    private static JButton botonCargarDatos;
    private static JFrame jFrame;
    private static JPanel panel;
    private  static JFileChooser cargarDatos;

    public static void crearMenu() {
        jFrame = new JFrame();
        jFrame.setPreferredSize(new Dimension(500, 500));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        movimientoAdelante = new JTextField();
        movimientoAtras = new JTextField();
        salto = new JTextField();
        disparo1 = new JComboBox();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        botonCargarDatos = new JButton();
        botonconfigurarControles = new JButton();
        botoniniciarJuego = new JButton();
        botoncontinuarJuego = new JButton();
        botonsalir = new JButton();

        cargarDatos =  new JFileChooser();
        fileFilter =  new FF();
        cargarDatos.setFileFilter(fileFilter);
        botonCargarDatos.setText("Cargar Datos");
        c.gridx = 1;
        c.gridy = 1;
        panel.add(botonCargarDatos, c);
        botonCargarDatos.addMouseListener(new AdaptadorMouse());

        botonconfigurarControles.setText("Configurar Controles");
        c.gridx = 1;
        c.gridy = 2;
        panel.add(botonconfigurarControles, c);
        botonconfigurarControles.addMouseListener(new AdaptadorMouse());


        botoniniciarJuego.setText("Iniciar Juego");
        c.gridx = 1;
        c.gridy = 3;
        panel.add(botoniniciarJuego, c);
        botoniniciarJuego.addMouseListener(new AdaptadorMouse());

        botoncontinuarJuego.setText("Continuar Juego");
        c.gridx = 1;
        c.gridy = 4;
        panel.add(botoncontinuarJuego, c);
        botoncontinuarJuego.addMouseListener(new AdaptadorMouse());

        botonsalir.setText("Salir");
        c.gridx = 1;
        c.gridy = 5;
        panel.add(botonsalir, c);
        botonsalir.addMouseListener(new AdaptadorMouse());

        jFrame.setContentPane(panel);
        jFrame.setVisible(true);
        jFrame.pack();

    }

    private static class AdaptadorMouse extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == botonsalir) {
                System.exit(1);
            } else if (e.getSource() == botoniniciarJuego) {
                jFrame.dispose();
                Juego.VentanaJuego();
            } else if (e.getSource() == botonCargarDatos) {
                int returnVal = cargarDatos.showOpenDialog(botonCargarDatos);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = cargarDatos.getSelectedFile();
                    System.out.println("Abriendo: " + file.getName() + "." + "\n");
                    ConfiguracionJuego.cargarConfiguracion(file);
                } else {
                    System.out.println("Operacion cancelada por el usuario." + "\n");
                }

            } else if (e.getSource() == botonconfigurarControles) {
                jFrame.dispose();
                MenuConfiguracion.crearMenuConfiguracion();
            } else if (e.getSource() == botoncontinuarJuego) {

            }
        }
    }
}

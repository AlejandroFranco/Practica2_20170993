import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Juego {

    private static JFrame ventanaJuego;

    public static void VentanaJuego() {
        ventanaJuego = new JFrame();
        ventanaJuego.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJuego.setPreferredSize(new Dimension(500, 500));
        ventanaJuego.setResizable(false);
        ventanaJuego.setLocationRelativeTo(null);
        ventanaJuego.setVisible(true);
        ventanaJuego.setContentPane(new ControlGraficos());
        ventanaJuego.pack();
    }


}
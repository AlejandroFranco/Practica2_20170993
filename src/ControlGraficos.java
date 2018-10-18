import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlGraficos extends JPanel implements ActionListener {

    private Proyectil[] proyectiles = new Proyectil[300];
    private int indice = 0;
    private int elementos = 0;
    private Cuphead cuphead = new Cuphead(300, 400);
    private boolean dibujarProyectil = false;
    private int posXPry;
    private int posYPry;
    private Timer t;

    public ControlGraficos() {
        JPanel p = new JPanel();
        setBackground(Color.white);
        JButton button = new JButton();
        getInputMap().put(KeyStroke.getKeyStroke("A"), "moverIzquierda");
        getActionMap().put("moverDerecha", moverDerecha);
        getInputMap().put(KeyStroke.getKeyStroke("D"), "moverDerecha");
        getActionMap().put("moverIzquierda", moverIzquierda);
        //disparos
        getInputMap().put(KeyStroke.getKeyStroke("K"), "disparo");
        getActionMap().put("disparo", disparo);
        t = new Timer(1, this);
    }

    Action moverDerecha = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

            /* Corregir la distanci maxima que cuphead recorre a la derecha*/
            //posicion actual de cuphead
            //evita repetir la invocacion de los mismos metodos
            final int ACT_ANCHO = cuphead.getAncho();
            final int ACT_ALTO = cuphead.getAlto();
            final int OFFSET = 1;
            //cuando se mueve cuphead pinto de nuevo el fondo   sobre la posicion vieja de cuphead
            repaint(cuphead.getPosX(), cuphead.getPosY(), ACT_ANCHO + OFFSET, ACT_ALTO + OFFSET);
            //actualizo la coordenada en x
            //int nuevaPosX = cuphead.posX;
            int nuevaPosX = cuphead.getPosX();
            nuevaPosX += 30;
            cuphead.setPosX(nuevaPosX);
            repaint(cuphead.getPosX() + 1, cuphead.getPosY() + 1, cuphead.getAncho(), cuphead.getAlto());
        }
    };

    Action disparo = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            posXPry = cuphead.getPosX() + 1;
            posYPry = cuphead.getPosY();
            cuphead.disparar(posXPry, posYPry);
            dibujarProyectil = true;
            repaint();
        }
    };

    Action moverIzquierda = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //posicion actual de cuphead
            //evita repetir7 la invocacion de los mismos metodos
            final int ACT_X = cuphead.getPosX();
            final int ACT_Y = cuphead.getPosY();
            final int ACT_ANCHO = cuphead.getAncho();
            final int ACT_ALTO = cuphead.getAlto();
            repaint(ACT_X, ACT_Y, ACT_ANCHO, ACT_ALTO);
            //actualizo la coordenada en x
            //int nuevaPosX = cuphead.posX;
            int nuevaPosX = cuphead.getPosX();
            nuevaPosX -= 30;
            //pinto de nuevo a cuphead en la nueva posicion
            cuphead.setPosX(nuevaPosX);
            repaint(cuphead.getPosX(), cuphead.getPosY(), 50, 50);
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        proyectiles = cuphead.getProyectiles().clone();
        System.out.println("qwertyuiop");
        for (int i = 0; i < proyectiles.length; i++) {
            if (proyectiles[i].isVisible()) {
                proyectiles[i].mover();
            } else {
                proyectiles[i] = null;
            }
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        cuphead.dibujarCuphead(g);
        if (dibujarProyectil) {
            for (int i = 0; i < cuphead.getProyectiles().length; i++) {
                t.start();
                cuphead.getProyectiles()[i].dibujarProyectil(g, posXPry, posYPry);
            }
        }
    }
}


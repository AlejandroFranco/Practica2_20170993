import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class ControlGraficos extends JPanel implements ActionListener {

    public static final int Ancho = 500;
    public static final int Alto = Ancho;

    private BufferedImage imagen = new BufferedImage(Ancho, Alto, BufferedImage.TYPE_INT_RGB);
    private int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    //private HojaFondo hojaFondo =  new HojaFondo("recursos/Escenario/fondo.png");

    private Proyectil pr;
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
        t.start();
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

    Action moverIzquierda = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //posicion actual de cuphead
            //evita repetir la invocacion de los mismos metodos
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


    Action disparo = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //agrego el proyectil que disparo a un arreglo de proyectiles
            //el disparo  siempre sale del frente de cuphead
            cuphead.disparar();
            dibujarProyectil = true;
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < cuphead.getDisparos(); i++) {
            if (cuphead.getProyectiles()[i].esVisible()) {
                //muevo el proyectil mientras sea visible
                cuphead.getProyectiles()[i].mover();
                //el proyectil tiene las nuevas coordenadas
                //actualizo el rectangulo que le corresponde a ese proyectil/imagen,
                //para ello dibujo el mismo rectangulo en diferente posicion
            } else {
                cuphead.getProyectiles()[i] = null;
                int disparos = cuphead.getDisparos();
                cuphead.setDisparos(disparos - 1);
            }
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        cuphead.dibujarCuphead(g);
            for (int i = 0; i < cuphead.getDisparos(); i++) {
                pr = cuphead.getProyectiles()[i];
                int posX =  cuphead.getProyectiles()[i].getPosX();
                int posY =  cuphead.getProyectiles()[i].getPosY();
                //si se ha disparado, grafico los proyectiles
                //estoy estableciendo mal la nueva posicion de cuphead
                pr.dibujarProyectil(g, posX, posY);
        }
    }


}


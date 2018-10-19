import java.awt.*;


public class Proyectil extends ObjetoJuego {

    private final int anchoProyectil = 10;
    private final int altoProyectil = 10;
    private int posX;
    private int posY;
    private boolean visible;

    public Proyectil(int x, int y) {
        posX = x;
        posY = y;
        visible = true;
    }

    public void dibujarProyectil(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillRect(x, y, anchoProyectil, altoProyectil);
    }

    public void mover() {
        if (posX > 500) {
           visible = false;
        } else {
            posX += 5;
        }
    }

    public int getAnchoProyectil() {
        return anchoProyectil;
    }

    public int getAltoProyectil() {
        return altoProyectil;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean esVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}

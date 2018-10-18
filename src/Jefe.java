import java.awt.*;

public class Jefe extends ObjetoJuego{

        private int posX = 300;
        private int posY = 400;
        private int ancho = 50;
        private int alto = 50;
        private Proyectil[] proyectiles;
        private int disparos = 0;

        public Jefe(int x, int y) {
            posX = x;
            posY = y;
            proyectiles = new Proyectil[200];
        }

        public void dibujarCuphead(Graphics g) {
            g.setColor(Color.blue);
            g.fillRect(posX, posY, ancho, alto);
        }

        public void disparar() {
            Proyectil proyectil = new Proyectil((getPosX() + 60), getPosY() + 60);
            proyectiles[disparos] = proyectil;
            disparos++;
        }

        public Proyectil[] getProyectiles() {
            return proyectiles;
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

        public int getAncho() {
            return ancho;
        }

        public void setAncho(int ancho) {
            this.ancho = ancho;
        }

        public int getAlto() {
            return alto;
        }

        public void setAlto(int alto) {
            this.alto = alto;
        }

        public int getDisparos() {
            return disparos;
        }

        public void setDisparos(int disparos) {
            this.disparos = disparos;
        }
    }


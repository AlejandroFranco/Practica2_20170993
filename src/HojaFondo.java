import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaFondo {


    String ruta;
    public int ancho;
    public int alto;
    public int[] pixeles;


    public HojaFondo(String ruta) {
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(HojaFondo.class.getResourceAsStream(ruta));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (imagen == null) {
            return;
        }

        this.ruta = ruta;
        this.alto = imagen.getHeight();
        this.ancho = imagen.getWidth();
        pixeles = imagen.getRGB(0, 0, ancho, alto, null, 0, ancho);
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = (pixeles[i] & 0xff) / 64;
        }

    }

}


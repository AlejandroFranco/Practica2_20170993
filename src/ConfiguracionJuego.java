import java.io.*;

public class ConfiguracionJuego {

    private static ConfiguracionJuego instancia;
    private static StringBuffer sb;

    // Singleton Serializadora
    public static ConfiguracionJuego getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionJuego();
        }
        return instancia;
    }

    public static void cargarConfiguracion(File file) {
        try {
            String archivo = file.getName().toString();
            if (archivo.contains(".cuphead")) {
                BufferedReader bf = new BufferedReader(new FileReader(file));
                sb = new StringBuffer();
                String linea = bf.readLine();
                while (linea != null) {
                    sb.append(linea);
                    linea = bf.readLine();
                }
            } else {
                System.out.println("archivo incorrecto...");
            }

        } catch (FileNotFoundException exception) {

        } catch (IOException e)

        {
            e.printStackTrace();
        }
    }

    public static String[] obtenerParametros() {
        String linea = sb.toString();
        String[] parametros = linea.split("\\$\\$");
        return parametros;
    }

    public static void guardarConfiguracion() {

    }
}

import java.io.File;

public class Utils {

    public final static String cuphead = "cuphead";

    /*
     *Conseguir  Extension de un  archivo.
     */

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
}


import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FF extends FileFilter {

    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }
        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.cuphead)){
                return true;
        } else {
            return false;
        }
        }
        return false;
    }


    @Override
    public String getDescription() {
        return null;
    }
}

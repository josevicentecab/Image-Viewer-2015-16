package IV.Application;

import java.io.FilenameFilter;
import javax.imageio.ImageIO;
import IV.Model.Image;
import IV.View.Reader;
import java.awt.image.BufferedImage;
import java.io.File;

public class FileViewer implements Reader {

    private final File[] imageFiles;
    private static final String[] extensions = {".JPG", ".PNG", ".GIF"};

    public FileViewer(String path) {
        this(new File(path));
    }
    public FileViewer(File folder) {
        this.imageFiles =  folder.listFiles(imageType());         
    }
    @Override
    public Image read() {
        return imageAt(0);
    }
    private FilenameFilter imageType() {
        return (File file, String name) -> {
            for (String extension : extensions)
                if (name.toUpperCase().endsWith(extension)) return true;
            return false;
        };
    }
    private Image imageAt(int index) {
        return new Image() {

            @Override
            public <T> T bitmap() {
                try {
                    return (T) ImageIO.read(imageFiles[index]);
                } catch (Exception e) {
                    return (T) new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
                }
            }
            @Override
            public Image next() {
                if (index >= imageFiles.length - 1) {
                    return imageAt(0);
                }
                return imageAt(index + 1);
            }
            @Override
            public Image prev() {
                return imageAt(index > 0 ? index - 1 : imageFiles.length - 1);
            }
        };
    }
}

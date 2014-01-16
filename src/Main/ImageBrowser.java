package Main;

import View.ImageViewer;
import View.GraphicalImageViewer;
import Model.ProxyImage;
import Model.RealImage;
import Model.Image;
import Model.ImageLoader;
import Control.PrevImageCommand;
import Control.MainFrame;
import Control.NextImageCommand;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageBrowser {
    String path = "C:\\Users\\Aday\\Pictures\\t";
    File folder = new File(path);
    File[] list = folder.listFiles();
    
    public static void main(String[] args) throws IOException {
        
        new ImageBrowser().execute();
    }

    private void execute() throws IOException {
        Image[] images = linkImages(createImages());
        ImageViewer viewer = createImageViewer(images[0]);
        createMainFrame(createCommands(viewer),viewer);
    }

    private Image[] createImages() throws IOException{
        Image[] images = new Image[numberOfImages()];
        for (int i = 0, j = 0; i < list.length; i++) {
           if (isImage(list[i])){
               images[j]=createImage(list[i]);
               j++;
           }
        }
        return images;
    }
    
    private Image createImage(final File file){
        return new ProxyImage(new ImageLoader() {

            @Override
            public Image load() {
                try {
                    return new RealImage(file);
                } catch (IOException ex) {
                    Logger.getLogger(ImageBrowser.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        });
    }


    private Image[] linkImages(Image[] images) {
        for (int i = 0; i < images.length; i++) {
            Image image = images[i];
            Image next = images[(i + 1) % images.length];
            Image prev = images[(i -1 + images.length) % images.length];
            image.setNext(next);
            image.setPrev(prev);
        }
        return images;
    }

    private int numberOfImages() throws IOException {
        int count=0;
        for (int i = 0; i < list.length; i++) {
            if (isImage(list[i])) count++;
        }
        return count;
    }

    private boolean isImage(File file) throws IOException {
        String type = Files.probeContentType(file.toPath());
        if(type != null && type.startsWith("image")) return true;
        else return false;
    }

    private ImageViewer createImageViewer(Image image) {
        ImageViewer viewer = new GraphicalImageViewer();
        viewer.setImage(image);
        return viewer;
    }
    
    private MainFrame createMainFrame(ActionListener[] listeners,ImageViewer viewer){
        return new MainFrame(listeners,viewer);
    }
    
    private ActionListener[] createCommands(ImageViewer viewer){
        return new ActionListener[]{
            new PrevImageCommand(viewer),
            new NextImageCommand(viewer)
        };
    }
    
}

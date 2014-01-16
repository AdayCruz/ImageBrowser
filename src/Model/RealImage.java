package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RealImage extends Image{
    
    File file;
    BufferedImage image = null;
    
    public RealImage(File file) throws IOException{
        this.file = file;
        image = ImageIO.read(file);
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public Image getNext() {
        return null;
    }

    @Override
    public Image getPrev() {
        return null;
    }

    @Override
    public void setNext(Image image) {
    }

    @Override
    public void setPrev(Image image) {
    }
    
}

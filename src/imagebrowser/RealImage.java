package imagebrowser;

import java.io.File;

public class RealImage extends Image{
    
    File file;
    Bitmap image = new Bitmap();
    
    public RealImage(File file){
        this.file = file;
        image.setPath(file.getPath());
    }

    @Override
    public Bitmap getImage() {
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

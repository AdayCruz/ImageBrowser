package imagebrowser;

public class ProxyImage extends Image {
    
    private final ImageLoader loader;
    private Image next;
    private Image prev;
    private Image realImage;
    
    public ProxyImage(ImageLoader imageLoader) {
        loader = imageLoader;
    }

    @Override
    public Image getImage() {
        return realImage;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image image) {
        this.next = image;
    }

    @Override
    public void setPrev(Image image) {
        this.prev = image;
    }
    
}

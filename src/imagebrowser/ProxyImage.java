package imagebrowser;

public class ProxyImage extends Image {
    
    private final ImageLoader loader;
    
    public ProxyImage(ImageLoader imageLoader) {
        loader = imageLoader;
    }

}

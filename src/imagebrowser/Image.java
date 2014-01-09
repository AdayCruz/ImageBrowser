package imagebrowser;

public abstract class Image {

    public abstract Image getImage();
    public abstract Image getNext();
    public abstract Image getPrev();
    
    public abstract void setNext(Image next);
    public abstract void setPrev(Image prev);

}

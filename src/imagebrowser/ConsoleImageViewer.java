package imagebrowser;

public class ConsoleImageViewer extends ImageViewer {

    @Override
    public void refresh() {
        System.out.println(getImage().getImage().getPath());
    }

}

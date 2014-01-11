package imagebrowser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class GraphicalImageViewer extends ImageViewer {

    int x;
    int y;
    private JPanel panel;
    private JPanel imagePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics graph) {
                graph.drawImage(getImage().getImage(), 0, 0, null);
                repaint();
            }
        };
    
    @Override
    public void refresh() {
        if (panel != null)panel.setBackground(Color.WHITE);
        if (panel != null)panel.add(imagePanel);
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
}

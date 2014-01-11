package imagebrowser;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class GraphicalImageViewer extends ImageViewer{

    int x1;
    int x2;
    int x;
    private JPanel panel;
    
    @Override
    public void refresh() {
        JPanel imagePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics graph) {
                graph.drawImage(getImage().getPrev().getImage(), -getImage().getPrev().getImage().getWidth()+x, 0, null);
                graph.drawImage(getImage().getImage(), x, 0, null);
                graph.drawImage(getImage().getNext().getImage(), getImage().getImage().getWidth()+x, 0, null);
                repaint();
            }
        };
        if (panel != null)panel.add(imagePanel);
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
        this.panel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                x1=me.getX();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                x=0;
                if (x1-x2>getImage().getImage().getWidth()/2){
                    setImage(getImage().getNext());
                    getImage().setNext(getImage().getNext());
                }else if(x2-x1>getImage().getImage().getWidth()/2){
                    setImage(getImage().getPrev());
                    getImage().setPrev(getImage().getPrev());
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        this.panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
                x2=me.getX();
                x=x2-x1;
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
        });
    }
    
}

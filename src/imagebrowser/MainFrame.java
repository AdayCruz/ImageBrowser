package imagebrowser;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

    private ActionListener[] listeners;
    private GraphicalImageViewer viewer;
    private JPanel panel = new JPanel();
    private int index = 0;
    
    public MainFrame(ActionListener[] listeners, ImageViewer viewer){
        super("Image Browser");
        this.listeners = listeners;
        this.viewer = (GraphicalImageViewer) viewer;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.viewer.setPanel(panel);
        this.viewer.refresh();
        this.createComponents();
        this.setVisible(true);
    }
    
    private void createComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.add(panel,BorderLayout.SOUTH);
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
    }

    private JButton createButton(String title) {
        JButton button = new JButton(title);
        button.addActionListener(listeners[index++]);
        return button;
    }

}

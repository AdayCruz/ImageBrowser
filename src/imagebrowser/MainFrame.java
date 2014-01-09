package imagebrowser;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

    private ActionListener[] listeners;
    private int index = 0;
    
    public MainFrame(ActionListener[] listeners){
        super("Image Browser");
        this.listeners = listeners;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLayout(new FlowLayout());
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createButton("Prev"));
        this.add(createButton("Next"));
    }
}

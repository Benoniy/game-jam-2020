import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public Component comp;

    public MyWindow(Component view) {
        super("Some Assembly Required");
        this.comp = view;
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
    }
}

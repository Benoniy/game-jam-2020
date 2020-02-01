import Resources.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import Resources.Constants;

public class View extends JComponent {
    // background colour
    public static final Color BG_COLOR = Color.black;
    AffineTransform spriteAffine;

    private Game game;

    public View(Game game) {

        this.game = game;
    }

    @Override
    public void paintComponent(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        // paint the background
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());

    }

    @Override
    public Dimension getPreferredSize() {
        return Constants.screenDimension;
    }
}
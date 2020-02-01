package Resources;

import java.awt.*;

public class Constants {
    // Window dimensions
    public static int width = 1280;
    public static int height = 720;
    public static Dimension screenDimension = new Dimension(width, height);

    // Used for the GameObject class
    public static final int DELAY = 20;  // in milliseconds
    public static final double DT = DELAY / 1000.0;  // in seconds
}

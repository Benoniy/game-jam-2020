import Resources.Vector2D;

import java.awt.*;
public class Constants {
    // Window dimensions
    public static int width = 1280;
    public static int height = 720;
    public static Dimension screenDimension = new Dimension(width, height);

    public static int blockSize = 96;
    public static int blockRadius = blockSize / 2;

    public static Vector2D controlPosition = new Vector2D(0, 0);

    // Used for the GameObject class
    public static final int DELAY = 20;  // in milliseconds
    public static final double DT = DELAY / 1000.0;  // in seconds

    public static int translate(int i){
        return i * blockSize;
    }

}

import Resources.Vector2D;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Constants {
    // Window dimensions
    public static int width = 1280;
    public static int height = 720;
    public static Dimension screenDimension = new Dimension(width, height);

    public static boolean ANIMATION_FRAME = false;

    public static int blockSize = 96;
    public static int blockRadius = blockSize / 2;

    public static Vector2D controlPosition = new Vector2D(0, 0);

    // Used for the GameObject class
    public static final int DELAY = 20;  // in milliseconds
    public static final double DT = DELAY / 1000.0;  // in seconds

    public static boolean backMusic = true;
    public static String pause = "mm";
    public static int pauseSelection = 1;

    public static int translate(int i){
        return i * blockSize;
    }

    public static void offsetControl(int x, int y){
        Constants.controlPosition.add(x * blockSize, y * blockSize);
    }

    public static void loadSettings() {
        File f = new File("settings.cfg");
        if (f.exists()){
            System.out.println("Settings file exists");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line = reader.readLine();
                line = line.toLowerCase().replace(" ", "").replace("resolution=", "");
                String[] args = line.split("x");
                Constants.width = Integer.parseInt(args[0]);
                Constants.height = Integer.parseInt(args[1]);
                Constants.screenDimension = new Dimension(width, height);
                reader.close();
            }
            catch (Exception e){

            }
        }
        else {

        }
    }
}

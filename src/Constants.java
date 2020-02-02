import Resources.Vector2D;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    // Window dimensions
    public static int width = 1280;
    public static int height = 720;
    public static Dimension screenDimension = new Dimension(width, height);

    public static List<String> allowedRes = Arrays.asList("640x480", "1280x720", "1920x1080");
    public static int currentRes = 1;
    public static String currentDia = "";
    public static boolean Interaction = false;


    public static long current = -1;
    public static long last = -1;
    public static long animationRate = 350;
    public static boolean ANIMATION_FRAME = false;
    public static int PLAYER_ANGLE = 0;

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

    public static void offsetControl(){
        Constants.controlPosition = new Vector2D((width/3), (height/8));
    }

    public static void saveSettings(){
        File f = new File("settings.cfg");
        f.delete();
        System.out.println("Settings file exists");
        String[] args = allowedRes.get(currentRes).split("x");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            String line = "resolution=" + args[0] + "x" + args[1];
            writer.write(line);
            Constants.width = Integer.parseInt(args[0]);
            Constants.height = Integer.parseInt(args[1]);
            Constants.screenDimension = new Dimension(width, height);
            writer.close();
        }
        catch (Exception e){

        }
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
                int count = 0;
                for (String s : allowedRes){
                    if (s.equals(args[0] + "x" + args[1])){
                        break;
                    }
                    count ++;
                }
                currentRes = count;
                reader.close();
            }
            catch (Exception e){

            }
        }
        else {

        }
    }
}

import Resources.ImageManager;

import java.awt.*;

public class Sprites {
    public static Image Wall1, Milyway1;
    static {
        try{
            Wall1 = ImageManager.loadImage("wall");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

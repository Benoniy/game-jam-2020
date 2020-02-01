import Resources.ImageManager;

import java.awt.*;

public class Sprites {
    public static Image Wall1, Floor1, Crate1;
    static {
        try{
            Wall1 = ImageManager.loadImage("wall");
            Floor1 = ImageManager.loadImage("floor");
            Crate1 = ImageManager.loadImage("crate");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
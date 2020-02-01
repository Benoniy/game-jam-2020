import Resources.ImageManager;

import java.awt.*;

public class Sprites {
    public static Image Wall1, Floor1, Crate1, WallEnd, WallCor, WallMid;
    static {
        try{
            Wall1 = ImageManager.loadImage("wall");
            WallEnd = ImageManager.loadImage("wallEnd");
            WallCor = ImageManager.loadImage("wallCorner");
            WallMid = ImageManager.loadImage("wallMid");
            Floor1 = ImageManager.loadImage("floor");
            Crate1 = ImageManager.loadImage("crate");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
import Resources.ImageManager;

import java.awt.*;

public class Sprites {
    public static Image Wall1, Floor1, Crate1, WallEnd, WallCor, WallMid, head, arm, legs, chest, doormid, doorend, doorbroke;
    static {
        try{
            Wall1 = ImageManager.loadImage("wall");
            WallEnd = ImageManager.loadImage("wallEnd");
            WallCor = ImageManager.loadImage("wallCorner");
            WallMid = ImageManager.loadImage("wallMid");
            Floor1 = ImageManager.loadImage("floor");
            Crate1 = ImageManager.loadImage("crate");
            doormid = ImageManager.loadImage("doormid");
            doorend = ImageManager.loadImage("doorend");
            doorbroke = ImageManager.loadImage("doorendbroken");
            // body parts
            head = ImageManager.loadImage("head");
            arm = ImageManager.loadImage("arm");
            legs = ImageManager.loadImage("legs");
            chest = ImageManager.loadImage("chest");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
import Resources.ImageManager;

import java.awt.*;

public class Sprites {
    public static Image Wall1, Floor1, Crate1, WallEnd, WallCor, WallMid, head, arm, legs, chest, doormid,
            doorend, doorbroke, menuSelect, hand1, hand2, barrel, back;
    static {
        try{
            // menu
            menuSelect = ImageManager.loadImage("menuThingy");
            back = ImageManager.loadImage("background");
            // environment
            Wall1 = ImageManager.loadImage("wall");
            WallEnd = ImageManager.loadImage("wallEnd");
            WallCor = ImageManager.loadImage("wallCorner");
            WallMid = ImageManager.loadImage("wallMid");
            Floor1 = ImageManager.loadImage("floor");
            Crate1 = ImageManager.loadImage("crate");
            doormid = ImageManager.loadImage("doormid");
            doorend = ImageManager.loadImage("doorend");
            doorbroke = ImageManager.loadImage("doorendbroken");
            barrel = ImageManager.loadImage("daru");
            // body parts
            head = ImageManager.loadImage("head");
            arm = ImageManager.loadImage("arm");
            legs = ImageManager.loadImage("legs");
            chest = ImageManager.loadImage("chest");
            //Player
            hand1 = ImageManager.loadImage("hand open");
            hand2 = ImageManager.loadImage("hand closed");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
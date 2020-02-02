import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class HeadObject extends EnviroObject {
    ArrayList headDoors;

    public HeadObject(int posX, int posY, ArrayList headDoors) {
        super(posX, posY, Constants.blockRadius, true, Sprites.head, 0);
        this.headDoors = headDoors;
        System.out.println(position);
        isInteractable = true;
    }

    @Override
    public void Interaction() {
        if(!Constants.chest && !Constants.arm && !Constants.legs){
            Constants.currentDia = "one";
        }
        else if (Constants.chest && !Constants.arm && !Constants.legs){
            Constants.currentDia = "two";
        }
        else if (Constants.chest && Constants.arm && !Constants.legs){
            Constants.currentDia = "three";
        }
        else if ((Constants.chest && Constants.arm && Constants.legs)){
            Constants.currentDia = "four";
        }

    }

    @Override
    public void addoffset(int x, int y) {

    }

    @Override
    public void draw(Graphics2D g) {

        /*
        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
        */

        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);

    }

}

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class LegsObject extends EnviroObject {
    ArrayList legDoors;

    public LegsObject(int posX, int posY, ArrayList legDoors) {
        super(posX, posY, Constants.blockRadius, true, Sprites.legs, 0);
        this.legDoors = legDoors;
        System.out.println(position);
        isInteractable = true;
    }

    @Override
    public void Interaction() {

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

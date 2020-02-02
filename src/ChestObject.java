import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class ChestObject extends EnviroObject {
    ArrayList chestDoors;

    public ChestObject(int posX, int posY, ArrayList chestDoors) {
        super(posX, posY, Constants.blockRadius, true, Sprites.chest, 0);
        this.chestDoors = chestDoors;
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

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class ArmObject extends EnviroObject {
    ArrayList armDoors;

    public ArmObject(int posX, int posY, ArrayList armDoors) {
        super(posX, posY, Constants.blockRadius, true, Sprites.hand1, 0);
        this.armDoors = armDoors;
        System.out.println(position);
        isInteractable = true;
    }

    @Override
    public void Interaction() {
        Constants.REMOVEobjects.addAll(armDoors);
        Constants.REMOVEobjects.add(this);
        Constants.arm = true;
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

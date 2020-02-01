import java.awt.*;
import java.awt.geom.AffineTransform;


public class DoorObject extends EnviroObject {
    public DoorObject(int posX, int posY, Image sprite, int theta) {
        super(posX, posY, Constants.blockRadius, true, sprite, theta);
        System.out.println(position);
    }
    @Override
    public void draw(Graphics2D g) {

        /*
        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
        */

        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, 5, 5);

        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);

    }

}

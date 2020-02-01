import java.awt.*;
import java.awt.geom.AffineTransform;

public class FloorObject extends EnviroObject {
    public FloorObject(int posX, int posY) {
        super(posX, posY,  Constants.blockRadius, false, Sprites.Floor1, 0);
    }
    @Override
    public void draw(Graphics2D g) {
        /*
        g.setColor(Color.GREEN);
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
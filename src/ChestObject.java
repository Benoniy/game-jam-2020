import java.awt.*;
import java.awt.geom.AffineTransform;

public class ChestObject extends EnviroObject {
    public ChestObject(int posX, int posY) {
        super(posX, posY, Constants.blockRadius, true, Sprites.chest, 0);
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

        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);

    }

}

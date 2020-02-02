import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.concurrent.ThreadLocalRandom;

public class CrateObject extends EnviroObject {
    public CrateObject(int posX, int posY, int thetAngle) {
        super(posX, posY, Constants.blockRadius, true, Sprites.Crate1, thetAngle);
        System.out.println(position);
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

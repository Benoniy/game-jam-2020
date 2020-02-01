import java.awt.*;
import java.awt.geom.AffineTransform;


public class WallObject extends EnviroObject {
    public WallObject(int posX, int posY, Image sprite) {
        super(posX, posY, Constants.blockRadius, true, sprite);
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

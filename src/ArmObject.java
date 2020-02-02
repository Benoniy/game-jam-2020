import java.awt.*;
import java.awt.geom.AffineTransform;

public class ArmObject extends EnviroObject {
    public ArmObject(int posX, int posY) {
        super(posX, posY, Constants.blockRadius, true, Sprites.arm, 0);
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

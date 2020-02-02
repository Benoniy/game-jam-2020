import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class BarrelObject extends EnviroObject {
    public BarrelObject(int posX, int posY, int theAngle) {
        super(posX, posY, Constants.blockRadius, true, Sprites.barrel, theAngle);
    }

    @Override
    public void Interaction() {

    }

    @Override
    public void addoffset(int x, int y) {
        System.out.println(position);
        this.offsetX += Constants.translate(x);
        this.offsetY += Constants.translate(y);
        this.offset = new Vector2D(offsetX, offsetY);
        this.position = new Vector2D(Constants.controlPosition).add(offsetX, offsetY);
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

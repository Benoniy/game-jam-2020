import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class MenuSelector extends GameObject{
    Image texture = Sprites.menuSelect;
    AffineTransform spriteAffine;

    MenuSelector(int posx, int posy){
        super(new Vector2D(posx - 48, posy +16), new Vector2D(0, 0), 16, false);
        genSpriteAffine();
    }

    public void genSpriteAffine(){
        double TxWidth = texture.getWidth(null);
        double TxHeight = texture.getHeight(null);
        double stretchX = ((this.radius * 2) /TxWidth);
        double stretchY = ((this.radius * 2) /TxHeight);

        spriteAffine = new AffineTransform();
        spriteAffine.scale(stretchX, stretchY);
    }

    public void moveSelector(int x, int y){
        position = new Vector2D(x - 48, y +16);
    }

    @Override
    public void Interaction() {

    }

    @Override
    public void addoffset(int x, int y) {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);
    }
}

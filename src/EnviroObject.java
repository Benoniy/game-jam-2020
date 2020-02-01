import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class EnviroObject extends GameObject {
    int offsetX, offsetY;
    double theta = 0;
    Vector2D offset;
    Image texture = null;
    AffineTransform spriteAffine;


    public EnviroObject(int posX, int posY, double radius, boolean collision, Image INtexture, double theta){
        super(new Vector2D(Constants.translate(posX), Constants.translate(posY)), new Vector2D(0,0), radius, collision);
        this.offsetX = Constants.translate(posX);
        this.offsetY = Constants.translate(posY);
        this.offset = new Vector2D(offsetX, offsetY);
        this.theta = theta;
        if (INtexture != null){
            this.texture = INtexture;
            genSpriteAffine();
        }
    }

    public void genSpriteAffine(){
        double TxWidth = texture.getWidth(null);
        double TxHeight = texture.getHeight(null);
        double stretchX = ((this.radius * 2) /TxWidth);
        double stretchY = ((this.radius * 2) /TxHeight);

        spriteAffine = new AffineTransform();
        spriteAffine.rotate( theta);
        spriteAffine.scale(stretchX, stretchY);

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
    }

    @Override
    public void update() {
        this.position = new Vector2D(Constants.controlPosition).add(offset);
    }
}

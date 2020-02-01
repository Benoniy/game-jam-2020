import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class controlBlock extends GameObject {
    Controller ctrl;
    public static final double DRAG = 1.0;
    public static final double MAG_ACC = 200;
    Image texture = Sprites.Wall1;
    AffineTransform spriteAffine;

    controlBlock(Controller ctrl){
        super(Constants.controlPosition, new Vector2D(0, 0), Constants.blockRadius, true);
        this.ctrl = ctrl;
        if (texture != null){
            genSpriteAffine();
        }
    }

    public void genSpriteAffine(){
        double TxWidth = texture.getWidth(null);
        double TxHeight = texture.getHeight(null);
        double stretchX = ((this.radius * 2) /TxWidth);
        double stretchY = ((this.radius * 2) /TxHeight);

        spriteAffine = new AffineTransform();
        spriteAffine.scale(stretchX, stretchY);

    }

    @Override
    public void draw(Graphics2D g) {
        /*
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
        */

        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);
    }

    @Override
    public void update() {
        if (ctrl.action().left) {
            velocity.addScaled(new Vector2D(-2,0), 2);
        }
        if (ctrl.action().right){
            velocity.addScaled(new Vector2D(2,0), 2);
        }

        if (ctrl.action().up){
            velocity.addScaled(new Vector2D(0,-2), 2);
        }
        if (ctrl.action().down){
            velocity.addScaled(new Vector2D(0,2), 2);
        }


        if (velocity.x < 0){
            velocity.add(DRAG, 0);
        }
        else if (velocity.x > 0){
            velocity.subtract(DRAG, 0);
        }

        if (velocity.y < 0){
            velocity.add(0, DRAG);
        }
        else if (velocity.y > 0){
            velocity.subtract(0, DRAG);
        }

        position.addScaled(velocity, Constants.DT);
    }

    public void stopLeft(){
        if (velocity.x < 0){
            velocity = new Vector2D(0,velocity.y);
        }

    }

    public void stopRight(){
        if (velocity.x > 0){
            velocity = new Vector2D(0,velocity.y);
        }

    }


    public void stopUp(){
        if (velocity.y < 0){
            velocity = new Vector2D(velocity.x,0);
        }

    }

    public void stopDown(){
        if (velocity.y > 0){
            velocity = new Vector2D(velocity.x,0);
        }
    }
}

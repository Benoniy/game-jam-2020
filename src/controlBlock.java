import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class controlBlock extends GameObject {
    Controller ctrl;
    public static final double DRAG = 40;
    public static final double SPEED = 16;
    public static final double LIMIT = 600;
    Image texture = Sprites.Floor1;
    AffineTransform spriteAffine;

    controlBlock(Controller ctrl){
        super(Constants.controlPosition, new Vector2D(0, 0), Constants.blockRadius, false);
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
        System.out.println(velocity);
        if (ctrl.action().left && velocity.x > -LIMIT) {
            velocity.subtract(new Vector2D(SPEED,0));
        }
        if (ctrl.action().right && velocity.x < LIMIT){
            velocity.add(new Vector2D(SPEED,0));
        }

        if (ctrl.action().up && velocity.y > -LIMIT){
            velocity.subtract(new Vector2D(0,SPEED));
        }
        if (ctrl.action().down && velocity.y < LIMIT){
            velocity.add(new Vector2D(0,SPEED));
        }


        if (velocity.x < 0 && !Action.left){

            velocity.add(DRAG, 0);
        }
        else if (velocity.x > 0 && !Action.right){
            velocity.subtract(DRAG, 0);
        }

        if (velocity.y < 0 && !Action.up){
            velocity.add(0, DRAG);
        }
        else if (velocity.y > 0 && !Action.down){
            velocity.subtract(0, DRAG);
        }

        position.addScaled(velocity, Constants.DT);

        if (velocity.x < 40 && velocity.x > -40 && velocity.y < 40 && velocity.y > -40 && !(Action.left || Action.right || Action.up || Action.down)){
            velocity = new Vector2D(0, 0);
        }
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

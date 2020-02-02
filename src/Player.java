import Resources.Action;
import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Player extends GameObject {
    private controlBlock control;
    int offset;
    double diam;
    boolean l, r, u, d = false;
    Image texture = Sprites.hand1;
    AffineTransform spriteAffine;

    public Player(controlBlock control){
        super(new Vector2D((Constants.width / 2) - Constants.blockRadius, (Constants.height / 2) - Constants.blockRadius), new Vector2D(0, 0), Constants.blockRadius - 10, true);
        this.control = control;
        this.offset = (int)(radius - Constants.blockRadius);
        this.diam = radius * 2;
        genSpriteAffine(0);
    }

    public void genSpriteAffine(int i){
        double TxWidth = texture.getWidth(null);
        double TxHeight = texture.getHeight(null);
        double stretchX = (diam /TxWidth);
        double stretchY = (diam/TxHeight);

        spriteAffine = new AffineTransform();

        for (int n = 0; n < i; n++){
            AffineRotate90(TxWidth, TxHeight);
        }

        spriteAffine.scale(stretchX, stretchY);
    }

    @Override
    public void update() {
        if (Action.left || Action.right || Action.up || Action.down){
            if (Constants.ANIMATION_FRAME){
                texture = Sprites.hand2;
            }
            else {
                texture = Sprites.hand1;
            }
        }
        else {
            texture = Sprites.hand1;
        }
        if(l != Action.left || r != Action.right || u != Action.up || d != Action.down){
            genSpriteAffine(Constants.PLAYER_ANGLE);
        }
    }

    public void AffineRotate90(double width, double height){
        spriteAffine.rotate(Math.PI/2, width / 2, height /2);
        double offset = (width - height)/2;
        spriteAffine.translate(-offset, -offset);
    }

    @Override
    public void draw(Graphics2D g) {
        /*
        g.setColor(Color.RED);

        g.fillOval((int)position.x - offset, (int)position.y - offset, (int)radius * 2, (int)radius * 2);
        g.setColor(Color.BLACK);
        g.drawOval((int)position.x - offset, (int)position.y - offset, (int)radius * 2, (int)radius * 2);

        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, 5, 5);
        */


        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);
    }

    /*
    public boolean overlap(GameObject other){

        if (position.x < other.position.x + Constants.blockSize - 10 && position.x + radius > other.position.x + 10 &&
                position.y < other.position.y + Constants.blockSize + 10 && position.y + Constants.blockRadius + radius > other.position.y - 10) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean resetOverlap(GameObject other){

        if (position.x < other.position.x + Constants.blockSize && position.x + radius > other.position.x &&
                position.y < other.position.y + Constants.blockSize && position.y + radius > other.position.y) {
            return true;
        }
        else{
            return false;
        }

    }
    */

    public void collisionHandling(GameObject other){
        if (other.collision) {
            if (this.overlap(other)) {

                double Yvar = ((position.y - radius) - (other.position.y + other.radius));
                double Xvar = ((position.x - radius) - (other.position.x + other.radius));

                if (Yvar > -80) {
                    control.stopDown();
                    Action.downAllowed = false;
                    Action.down = false;
                }
                if (Yvar < -100) {
                    control.stopUp();
                    Action.upAllowed = false;
                    Action.up = false;
                }

                if (Xvar > -80) {
                    control.stopRight();
                    Action.rightAllowed = false;
                    Action.right = false;
                }

                if (Xvar < -100) {
                    control.stopLeft();
                    Action.leftAllowed = false;
                    Action.left = false;
                }
            }
            else if (!this.overlap(other) && this.resetOverlap(other)) {
                Action.leftAllowed = true;
                Action.rightAllowed = true;
                Action.upAllowed = true;
                Action.downAllowed = true;
            }
        }
    }
}

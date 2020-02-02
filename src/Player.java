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
        super(new Vector2D((Constants.width / 2) - Constants.blockRadius, (Constants.height / 2) - Constants.blockRadius), new Vector2D(0, 0), Constants.blockRadius, true);
        this.control = control;
        this.offset = (int)(radius - Constants.blockRadius);
        this.diam = radius * 2;
        genSpriteAffine(0);
    }

    public void genSpriteAffine(int i){
        double TxWidth = texture.getWidth(null);
        double TxHeight = texture.getHeight(null);
        double stretchX = (diam/TxWidth);
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

        Vector2D fakeVec = new Vector2D(control.velocity);
        System.out.println(control.velocity);
        if (fakeVec.x > fakeVec.y && fakeVec.x > -fakeVec.x && fakeVec.x > -fakeVec.y){
            Constants.PLAYER_ANGLE = 3;
        }
        else if (-fakeVec.x > fakeVec.y && -fakeVec.x > fakeVec.x && -fakeVec.x > -fakeVec.y){

            Constants.PLAYER_ANGLE = 1;
        }
        else if (fakeVec.y > fakeVec.x && fakeVec.y > -fakeVec.x && fakeVec.y > -fakeVec.y){
            Constants.PLAYER_ANGLE = 0;
        }
        else if (-fakeVec.y > fakeVec.x && -fakeVec.y > -fakeVec.x && -fakeVec.y > fakeVec.y){

            Constants.PLAYER_ANGLE = 2;
        }

        genSpriteAffine(Constants.PLAYER_ANGLE);

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

    @Override
    public void Interaction() {}

    public boolean interactOverlap(GameObject other){

        if (position.dist(other.position) < (radius + Constants.blockRadius) + (other.radius + Constants.blockRadius)) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean interactOverlapReset(GameObject other){

        if (position.dist(other.position) < (radius + Constants.blockRadius + 10) + (other.radius + Constants.blockRadius + 10)) {
            return true;
        }
        else{
            return false;
        }
    }

    public void collisionHandling(GameObject other){
        if (other.isInteractable){
            if(this.interactOverlap(other)){
                Constants.Interaction = true;
                other.Interaction();
            }
            else if (!this.interactOverlap(other) && this.interactOverlapReset(other)) {
                Constants.Interaction = false;
            }
        }
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

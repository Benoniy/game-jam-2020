import Resources.Vector2D;

import java.awt.*;

public class Player extends GameObject {
    private controlBlock control;
    int offset;
    double diam;

    public Player(controlBlock control){
        super(new Vector2D((Constants.width / 2) - Constants.blockRadius, (Constants.height / 2) - Constants.blockRadius), new Vector2D(0, 0), Constants.blockRadius - 10, true);
        this.control = control;
        this.offset = (int)(radius - Constants.blockRadius);
        this.diam = radius * 2;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);

        g.fillOval((int)position.x - offset, (int)position.y - offset, (int)radius * 2, (int)radius * 2);
        g.setColor(Color.BLACK);
        g.drawOval((int)position.x - offset, (int)position.y - offset, (int)radius * 2, (int)radius * 2);

        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, 5, 5);
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
                }
                if (Yvar < -100) {
                    control.stopUp();
                    Action.upAllowed = false;
                }

                if (Xvar > -80) {
                    control.stopRight();
                    Action.rightAllowed = false;

                }

                if (Xvar < -100) {
                    control.stopLeft();
                    Action.leftAllowed = false;
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

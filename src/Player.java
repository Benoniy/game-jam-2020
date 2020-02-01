import Resources.Vector2D;

import java.awt.*;

public class Player extends GameObject {
    private controlBlock control;

    public Player(controlBlock control){
        super(new Vector2D((Constants.width / 2) - Constants.blockRadius, (Constants.height / 2) - Constants.blockRadius), new Vector2D(0, 0), Constants.blockRadius, true);
        this.control = control;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval((int)position.x, (int)position.y, Constants.blockRadius * 2, Constants.blockRadius * 2);
        g.setColor(Color.BLACK);
        g.drawOval((int)position.x, (int)position.y, Constants.blockRadius * 2, Constants.blockRadius * 2);
    }

    public void collisionHandling(GameObject other){
        if (other.collision) {
            if (this.overlap(other)) {

                double Yvar = ((position.y - radius) - (other.position.y + other.radius));
                double Xvar = ((position.x - radius) - (other.position.x + other.radius));
                System.out.println(Xvar);

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
            else if (!this.overlap(other) && this.trueOverlap(other)) {
                Action.leftAllowed = true;
                Action.rightAllowed = true;
                Action.upAllowed = true;
                Action.downAllowed = true;
            }
        }
    }
}

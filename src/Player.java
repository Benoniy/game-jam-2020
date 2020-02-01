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

        if (this.overlap(other) && this.trueOverlap(other)){
            System.out.println("Colliding");
            int posX = (int)position.x + (Constants.blockSize / 2);
            int posy = (int)position.y  + (Constants.blockSize / 2);
            int OposX = (int)other.position.x  + (Constants.blockSize / 2);
            int Oposy = (int)other.position.y  + (Constants.blockSize / 2);

            if (posX - radius < OposX + other.radius){
                control.stopRight();
                Action.rightAllowed = false;

            }
            else if (posX - radius > OposX - other.radius){
                control.stopLeft();
                Action.leftAllowed = false;
            }
            if (posy - radius < Oposy + other.radius){
                control.stopUp();
                Action.upAllowed = false;
            }
            else if (posy - radius > Oposy - other.radius){
                control.stopDown();
                Action.downAllowed = false;
            }
        }
        else if (this.trueOverlap(other)){
            Action.leftAllowed = true;
            Action.rightAllowed = true;
            Action.upAllowed = true;
            Action.downAllowed = true;
        }
    }
}

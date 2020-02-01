import Resources.Vector2D;

import java.awt.*;

public class controlBlock extends GameObject {

    Controller ctrl;
    public static final double DRAG = 1.0;
    public static final double MAG_ACC = 200;

    controlBlock(Controller ctrl){
        super(Constants.controlPosition, new Vector2D(0, 0), Constants.blockRadius);
        this.ctrl = ctrl;


    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
    }

    @Override
    public void update() {
        if (ctrl.action().Xmov == -1) {
            velocity.addScaled(new Vector2D(-2,0), 2);
            System.out.println("ADD");
        }
        else if (ctrl.action().Xmov == 1){
            velocity.addScaled(new Vector2D(2,0), 2);
        }

        if (ctrl.action().Ymov == -1){
            velocity.addScaled(new Vector2D(0,-2), 2);
        }
        else if (ctrl.action().Ymov == 1){
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
}

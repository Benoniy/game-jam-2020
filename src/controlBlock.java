import Resources.Vector2D;

import java.awt.*;

public class controlBlock extends GameObject {

    controlBlock(){
        super(Constants.controlPosition, new Vector2D(0, 0), Constants.blockRadius);
        System.out.println(position);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
    }
}

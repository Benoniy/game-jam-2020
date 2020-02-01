import Resources.Vector2D;

import java.awt.*;

public class Player extends GameObject {

    public Player(){
        super(new Vector2D((Constants.width / 2) - Constants.blockRadius, (Constants.height / 2) - Constants.blockRadius), new Vector2D(0, 0), Constants.blockRadius);

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval((int)position.x, (int)position.y, Constants.blockRadius, Constants.blockRadius);
        g.setColor(Color.BLACK);
        g.drawOval((int)position.x, (int)position.y, Constants.blockRadius, Constants.blockRadius);
    }
}

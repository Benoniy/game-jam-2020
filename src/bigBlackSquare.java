import Resources.Vector2D;

import java.awt.*;

public class bigBlackSquare extends GameObject {
    public bigBlackSquare(){
        super(new Vector2D(0, 0), new Vector2D(0, 0), 0, false);
    }

    @Override
    public void Interaction() {

    }

    @Override
    public void addoffset(int x, int y) {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(0,0, Constants.width, Constants.height);
    }
}
